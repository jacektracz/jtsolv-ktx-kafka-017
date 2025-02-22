package com.jtsolv.jtsolvcurr.kafkadirectoperations;

// KafkaProducerExample.java
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
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
            produceMessagesInternal(dt);
        } catch (Exception e) {
            dbg(mtd + "Error creating topic: " + e.getMessage());
            err(mtd + "Error creating topic: " + e.getMessage());
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;

        }
        JTSolvKafkaResultData resultOk = new JTSolvKafkaResultData();
        resultOk.setResultCode("200");
        return resultOk;
    }

    public static void produceMessagesInternal(
            JTSolvKafkaRequestData dt
            ) {
        String mtd = getCn() + ":produceMessagesInternal:";
        dbg(mtd + "start");
        String topic = dt.getTopic();
        String keyPrefix = dt.getKeyPrefix();
        long numberOfSend = Long.valueOf(dt.getNumbers());
        // Set Kafka producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", dt.getKafkaServer()); // Kafka server
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        // Create the Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(properties);
        String initialKey = "key_" + keyPrefix + "_onto_topic_" + topic;
        String initialValue = initialKey + dt.getMessageValue();
        for (int ii =0 ; ii< numberOfSend; ii++ ) {
            String key = initialKey + ii;
            String value = initialValue + ii + "--" + key;
            sendValue(producer, topic, key, value);
        }
        // Send a record (message)

        // Close the producer
        producer.close();
        dbg(mtd + "end");

    }

    private static void sendValue(Producer<String, String> producer,
                                  String topic,
                                  String key,
                                  String value) {
        String mtd = getCn() + ":sendValue:";
        dbg(mtd + "start");

        dbg("Before send message: [key:" + key + "]");
        dbg("Before send message: [value:" + value + "]");
        producer.send(new ProducerRecord<>(topic, key, value), (metadata, exception) -> {
            if (exception != null) {
                dbg("Error while producing message: " + exception.getMessage());
            } else {
                dbg("Message sent successfully.");
                dbg("Partition: " + metadata.partition());
                dbg("Topic: " + metadata.topic());
                dbg("Offset: " + metadata.offset());
                dbg("Timestamp: " + metadata.timestamp());
                dbg("Message: " + value);
                dbg("HasTimestamp: " + metadata.hasTimestamp());
            }
        });
        dbg(mtd + "end");
    }

    private static void dbg(String txt){
        logger.trace(txt);
    }

    private String err (String txt){
        logger.trace(txt);
        logger.error(txt);
        return txt;
    }

}
