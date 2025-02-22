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
                "192.168.55.103:9092",
                "0",
                "0",
                "0");
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
            dbg(mtd +"Consume in loop number:" + ii);
            dbg(mtd +"Consumer pool start wait for milisecons:" + ii);
            consumer.poll(milliseconds).forEach(record -> {
                dbg(mtd + "Consumed message: " + record.value() );
                dbg(mtd + "Consumed from partition: " + record.partition());
                dbg(mtd + "Consumed offset: " + record.offset());
                dbg(mtd + "Consumed key: " + record.key());
                dbg(mtd + "Consumed groupId: " + consumer.groupMetadata().groupId());
                dbg(mtd + "Consumed memberId: " + consumer.groupMetadata().memberId());
                dbg(mtd + "Consumed generationId: " + consumer.groupMetadata().generationId());
            });
            ii++;
            dbg(mtd +"Sleep start:");
            if (ii > Long.valueOf(numberOfMessages)){
                break;
            }
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                err("error", e);
            }
            dbg(mtd +"Sleep end:");

        }
        return resultData;
    }

    private static void dbg(String txt){
        logger.trace(txt);
    }

    private static String err (String txt, Exception e){
        logger.trace(txt);
        logger.error(txt);
        return txt;
    }

}
