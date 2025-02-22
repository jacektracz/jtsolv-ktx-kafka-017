package com.jtsolv.jtsolvcurr.kafkadirectoperations;

// KafkaConsumerExample.java
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Properties;

@Component
public class JTSolvKafkaDirectConsumerService {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectConsumerService.class.getName());

    private static String getCn() {
        return JTSolvKafkaDirectTopicCreatorService.class.getName();
    }

    public static void main(String[] args) {
        consumeMessageInternal(
                "jtsolv-group-2",
                "topic-repl-4",
                "192.168.55.103:9092",0,0,0);
    }


    public JTSolvKafkaResultData consumeMessage(
            JTSolvKafkaRequestData dt) {
        String mtd = getCn() + ":consumeMessage:";
        dbg(mtd + "start");

        JTSolvKafkaResultData resultDt = consumeMessageInternal(
                dt.getGroupId(),
                dt.getTopic(),
                dt.getBrokerId(),
                dt.getNumbers(),
                dt.getStartoffset(),
                dt.getEndoffset());
        dbg(mtd + "start");
        return resultDt;
    }

    public static JTSolvKafkaResultData consumeMessageInternal(
            String groupId,
            String topic,
            String brokerId ,
            String numberOfMessages,
            String startoffest,
            String endOffset) {
        String mtd = getCn() + ":consumeMessageInternal:";
        dbg(mtd + "start");
        JTSolvKafkaResultData resultData = new JTSolvKafkaResultData();
        // Set Kafka consumer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", brokerId); // Kafka server
        properties.put("group.id", groupId); // Consumer group
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        properties.put("auto.offset.reset", "earliest"); // Start reading from the earliest message

        // Create the Kafka consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Subscribe to the topic

        consumer.subscribe(Collections.singletonList(topic));

        // Poll messages from the topic
        int ii = 0;
        while (true) {
            long milliseconds = 1000;
            dbg("Consume in loop number:" + ii);
            dbg("Consumer pool start wait for milisecons:" + ii);
            consumer.poll(milliseconds).forEach(record -> {
                dbg("Consumed message: " + record.value() );
                dbg("Consumed from partition: " + record.partition());
                dbg("Consumed offset: " + record.offset());
                dbg("Consumed key: " + record.key());
                dbg("Consumed groupId: " + consumer.groupMetadata().groupId());
                dbg("Consumed memberId: " + consumer.groupMetadata().memberId());
                dbg("Consumed generationId: " + consumer.groupMetadata().generationId());
            });
            ii++;
            dbg("Sleep start:");
            if (ii > Long.valueOf(numberOfMessages)){
                break;
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dbg("Sleep end:");

        }
        return resultData;
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
