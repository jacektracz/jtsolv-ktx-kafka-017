package com.jtsolv.jtsolvcurr.kafkadirectoperations;

// KafkaConsumerExample.java
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaMessageData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
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
        /*
        consumeMessageInternal(
                "jtsolv-group-2",
                "topic-repl-4",
                "192.168.55.103:9092",
                "0",
                "0",
                "0");
         */
    }

    public JTSolvKafkaResultData consumeMessage(
            JTSolvKafkaRequestData dt) {
        String mtd = getCn() + ":consumeMessage:";
        dbg(mtd + "start");
        JTSolvKafkaResultData resultDt = consumeMessageInternal(dt);
        dbg(mtd + "start");
        return resultDt;

    }

    public static JTSolvKafkaResultData consumeMessageInternal(
            JTSolvKafkaRequestData dt) {
        String mtd = getCn() + ":consumeMessageInternal:";
        dbg(mtd + "start");

        String groupId = dt.getGroupId();
        String topic = dt.getTopic();
        String brokerId = dt.getBrokerId();
        String numberOfMessages = dt.getNumbers();
        String startoffest = dt.getStartoffset();
        String endOffset = dt.getEndoffset();
        JTSolvKafkaResultData resultData = new JTSolvKafkaResultData();
        // Set Kafka consumer properties
        Properties properties = new Properties();
        String stringSerializer = StringDeserializer.class.getName();
        properties.put("bootstrap.servers", brokerId); // Kafka server
        properties.put("group.id", groupId); // Consumer group
        properties.put("key.deserializer", stringSerializer);
        properties.put("value.deserializer", stringSerializer);
        properties.put("auto.offset.reset", "earliest"); // Start reading from the earliest message

        // Create the Kafka consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Subscribe to the topic
        dbg(mtd + "Subscribe to topic: " + topic );
        dbg(mtd + "Subscribe to groupId: " + groupId );
        dbg(mtd + "Subscribe to servers: " + brokerId );
        dbg(mtd + "Subscribe to value serializer: " + stringSerializer );
        dbg(mtd + "Subscribe to key serializer: " + stringSerializer );

        consumer.subscribe(Collections.singletonList(topic));

        // Poll messages from the topic
        int iterationIdx = 0;
        int messagesNumber = 0;
        while (true) {
            long milliseconds = Long.valueOf(dt.getThreadKafkaPoolingTime());
            dbg(mtd + "Consume in loop number:" + iterationIdx);
            dbg(mtd + "Consumer pool start wait for milliseconds:" + milliseconds);
            ConsumerRecords<String,String> records = consumer.poll(milliseconds);

            for (ConsumerRecord<String,String> record : records){
                messagesNumber++;
                JTSolvKafkaMessageData messageDt = new JTSolvKafkaMessageData();
                dbg(mtd + "Consumed message: " + record.value() );
                messageDt.setKafkaMessageValue(record.value());
                dbg(mtd + "Consumed from partition: " + record.partition());
                messageDt.setKafkaMessagePartitionId(String.valueOf(record.partition()));
                dbg(mtd + "Consumed offset: " + record.offset());
                messageDt.setKafkaMessageOffsetId(String.valueOf(record.offset()));
                dbg(mtd + "Consumed key: " + record.key());
                messageDt.setKafkaMessageKey(String.valueOf(record.key()));
                dbg(mtd + "Consumed groupId: " + consumer.groupMetadata().groupId());
                messageDt.setKafkaMessageGroupId(String.valueOf(consumer.groupMetadata().groupId()));
                dbg(mtd + "Consumed memberId: " + consumer.groupMetadata().memberId());
                messageDt.setKafkaMessageMemberId(String.valueOf(consumer.groupMetadata().memberId()));
                dbg(mtd + "Consumed generationId: " + consumer.groupMetadata().generationId());
                messageDt.setKafkaMessageMemberId(String.valueOf(consumer.groupMetadata().generationId()));
                resultData.getResultMessages().add(messageDt);
                if (messagesNumber > Long.valueOf(numberOfMessages)){
                    break;
                }
            }

            iterationIdx++;
            dbg(mtd + "Sleep start:");
            if (iterationIdx > Long.valueOf(numberOfMessages)){
                break;
            }

            try {
                Thread.sleep(Long.valueOf(dt.getThreadSleepPooling()));
            } catch (Exception e) {
                JTSolvKafkaMessageData messageDt = new JTSolvKafkaMessageData();
                messageDt.setKafkaMessageErrorMessage(err("error", e));
                messageDt.setKafkaMessageResults("500");
                resultData.getResultMessages().add(messageDt);
            }
            dbg(mtd + "Sleep end:");
        }
        return resultData;
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
