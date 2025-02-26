package com.jtsolv.jtsolvcurr.kafkadirectoperations.services;

// KafkaProducerExample.java
import com.jtsolv.jtsolvcurr.kafkadto.*;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class JTSolvKafkaDirectProducerService {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectProducerService.class.getName());

    private static String getCn() {
        return JTSolvKafkaDirectTopicCreatorService.class.getName();
    }

    public static void main(String[] args) {
        //produceMessagesInternal("jtsolv-raw-topic--002","33",300);
        //produceMessagesInternal("topic-repl-4","34",300);
    }

    public JTSolvKafkaResultData produceMessage(
            JTSolvKafkaRequestWriteMessagesData dt
            ) {

        String mtd = getCn() + ":produceMessage:";
        dbg(mtd + "start");
        try {
            JTSolvKafkaResultData resultOk = produceMessagesInternal(dt);
            resultOk.setResultCode("200");
            return resultOk;
        } catch (Exception e) {
            String msg = err(mtd + "exception", e);
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(msg);
            return resultErr;

        }

    }

    public static JTSolvKafkaResultData produceMessagesInternal(
            JTSolvKafkaRequestWriteMessagesData dt) {
        String mtd = getCn() + ":produceMessagesInternal:";
        dbg(mtd + "start");
        JTSolvKafkaResultData result = new JTSolvKafkaResultData();
        JTSolvKafkaTopicData topic = new JTSolvKafkaTopicData(dt.getTopic());
        String keyPrefix = dt.getKeyPrefix();
        long numberOfSend = Long.valueOf(dt.getMessageWriteNumbers());
        // Set Kafka producer properties

        String server = dt.getBrokerId();
        String valueSerializer = StringSerializer.class.getName();
        String keySerializer = StringSerializer.class.getName();
        dbg(mtd + "server:" + server);
        dbg(mtd + "keySerializer:" + keySerializer);
        dbg(mtd + "valueSerializer:" + valueSerializer);
        Properties properties = new Properties();
        properties.put("bootstrap.servers", server); // Kafka server
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);

        // Create the Kafka producer

        String initialKey = "key_" + keyPrefix + "_onto_topic_" + topic.getTopicValue();

        Producer<String, String> producer = new KafkaProducer<>(properties);
        try {
            for (int ii = 0; ii < numberOfSend; ii++) {
                try {
                    JTSolvKafkaMessageKeyData key = new JTSolvKafkaMessageKeyData(
                            initialKey + "-" + ii);
                    JTSolvKafkaMessageBodyData value = dt.getMessageBody();
                    sendValue(
                            result,
                            producer,
                            topic,
                            key,
                            value);
                } catch (Exception ex) {
                    result.setResultErrorMessage(
                            err("error-occured-for-sending-one-message", ex));
                    result.setResultCode("500");
                }
            }
        } catch (Exception ex ) {
            result.setResultErrorMessage(
                    err("error-occurred-in-sending-messages", ex));
            result.setResultCode("500");
        }
        finally {
            if ( producer != null ) {
                producer.close();
            }
        }
        // Close the producer
        dbg(mtd + "end");
        return result;
    }

    private static void sendValue(
            JTSolvKafkaResultData result,
            Producer<String, String> producer,
            JTSolvKafkaTopicData topic,
            JTSolvKafkaMessageKeyData key,
            JTSolvKafkaMessageBodyData value) {
        String mtd = getCn() + ":sendValue:";
        dbg(mtd + "start");

        dbg(mtd + "Before send message: [key:" + key.getKeyValue() + "]");
        dbg(mtd + "Before send message: [value:" + value.getMessageBodyValue() + "]");
        dbg(mtd + "Before send message: [topic:" + topic.getTopicValue() + "]");

        producer.send(new ProducerRecord<>(
                topic.getTopicValue(),
                key.getKeyValue(),
                value.getMessageBodyValue()),
                (metadata, exception) -> {

            if (exception != null) {
                JTSolvKafkaMessageData errValue = new JTSolvKafkaMessageData();
                errValue.setKafkaMessageErrorMessage(
                        dbg(mtd + "Error while producing message: "
                                + exception.getMessage()));
                errValue.setKafkaMessageResultCode("500");
                result.setResultCode("500");
                result.getResultMessages().add(errValue);
            } else {
                JTSolvKafkaMessageData successValue = new JTSolvKafkaMessageData();
                dbg(mtd + "Message sent successfully.");
                dbg(mtd + "Partition: " + metadata.partition());
                successValue.setKafkaMessagePartitionId(String.valueOf(metadata.partition()));
                dbg(mtd + "Topic: " + metadata.topic());
                successValue.setKafkaMessageTopic(String.valueOf(metadata.topic()));
                successValue.setKafkaMessageKey(key.getKeyValue());
                dbg(mtd + "Offset: " + metadata.offset());
                successValue.setKafkaMessageOffsetId(String.valueOf(metadata.offset()));
                dbg(mtd + "Timestamp: " + metadata.timestamp());
                successValue.setKafkaMessageTimestamp(String.valueOf(metadata.timestamp()));
                dbg(mtd + "Message: " + value.getMessageBodyValue());
                successValue.setKafkaMessageValue(String.valueOf(value.getMessageBodyValue()));
                dbg(mtd + "HasTimestamp: " + metadata.hasTimestamp());
                successValue.setKafkaMessageResultCode("200");
                result.getResultMessages().add(successValue);
            }
        });
        dbg(mtd + "end");
    }

    private static String dbg (String txt){
        JTSolvStaticExtenderLogger.logGenericInfo(logger,txt);
        return txt;
    }

    private static String err (String txt,Exception ex){
        JTSolvStaticExtenderLogger.logGenericInfo(logger,txt);
        String txtOut = JTSolvStaticExtenderLogger.logGenericException(logger,ex,txt);
        return txtOut;
    }

}
