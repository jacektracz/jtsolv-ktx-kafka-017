package com.jtsolv.jtsolvcurr.kafkadirectoperations;

// KafkaProducerExample.java
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaMessageData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
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
            JTSolvKafkaRequestData dt
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
            JTSolvKafkaRequestData dt
            ) {
        String mtd = getCn() + ":produceMessagesInternal:";
        dbg(mtd + "start");
        JTSolvKafkaResultData result = new JTSolvKafkaResultData();
        String topic = dt.getTopic();
        String keyPrefix = dt.getKeyPrefix();
        long numberOfSend = Long.valueOf(dt.getNumbers());
        // Set Kafka producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", dt.getKafkaServer()); // Kafka server
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        // Create the Kafka producer

        String initialKey = "key_" + keyPrefix + "_onto_topic_" + topic;
        String initialValue = initialKey + dt.getMessageValue();
        Producer<String, String> producer = new KafkaProducer<>(properties);
        try {

            for (int ii = 0; ii < numberOfSend; ii++) {
                try {
                    String key = initialKey + ii;
                    String value = initialValue + ii + "--" + key;
                    sendValue(result, producer, topic, key, value);
                } catch (Exception ex) {
                    err("error-occured-for-sending-one-message", ex);
                }
            }
            // Send a record (message)
        } catch (Exception ex ) {
            err("error-occured-for-sending-messages", ex);
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
            String topic,
            String key,
            String value) {
        String mtd = getCn() + ":sendValue:";
        dbg(mtd + "start");

        dbg(mtd + "Before send message: [key:" + key + "]");
        dbg(mtd + "Before send message: [value:" + value + "]");
        producer.send(new ProducerRecord<>(topic, key, value), (metadata, exception) -> {
            if (exception != null) {
                JTSolvKafkaMessageData errValue = new JTSolvKafkaMessageData();
                errValue.setKafkaMessageErrorMessage(
                        dbg(mtd + "Error while producing message: "
                                + exception.getMessage()));
                result.getResultMessages().add(errValue);
            } else {
                JTSolvKafkaMessageData successValue = new JTSolvKafkaMessageData();
                dbg(mtd + "Message sent successfully.");
                dbg(mtd + "Partition: " + metadata.partition());
                successValue.setKafkaMessagePartitionId(String.valueOf(metadata.partition()));
                dbg(mtd + "Topic: " + metadata.topic());
                successValue.setKafkaMessageTopic(String.valueOf(metadata.topic()));
                dbg(mtd + "Offset: " + metadata.offset());
                successValue.setKafkaMessageOffsetId(String.valueOf(metadata.offset()));
                dbg(mtd + "Timestamp: " + metadata.timestamp());
                successValue.setKafkaMessageTimestamp(String.valueOf(metadata.timestamp()));
                dbg(mtd + "Message: " + value);
                successValue.setKafkaMessageValue(String.valueOf(value));
                dbg(mtd + "HasTimestamp: " + metadata.hasTimestamp());
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
