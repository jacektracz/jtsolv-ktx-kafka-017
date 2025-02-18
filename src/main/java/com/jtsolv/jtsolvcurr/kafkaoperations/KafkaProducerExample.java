package com.jtsolv.jtsolvcurr.kafkaoperations;

// KafkaProducerExample.java
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        produce("jtsolv-raw-topic--002","33",300);
        produce("topic-repl-4","34",300);
    }

    public static void produce(String topic,String keyPrefix,int numberOfMessages) {
        // Set Kafka producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.55.103:9092"); // Kafka server
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        // Create the Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(properties);


        String initialKey = "key_" + keyPrefix + "_onto_topic_" + topic;
        String initialValue = initialKey + " Hello Kafka By Jacek Tracz (JTSOLV)!:";
        int numberOfSend = numberOfMessages;
        for (int ii =0 ; ii< numberOfSend; ii++ ) {
            String key = initialKey + ii;
            String value = initialValue + ii + "--" + key;
            sendValue(producer, topic, key, value);
        }
        // Send a record (message)

        // Close the producer
        producer.close();
    }

    private static void sendValue(Producer<String, String> producer,
                                  String topic,
                                  String key,
                                  String value) {
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
    }

    private static void dbg(String txt){
        System.out. println(txt);
    }
}
