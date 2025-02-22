package com.jtsolv.jtsolvcurr.kafkadirectoperations;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Properties;

@Component
public class JTSolvKafkaTopicCreatorService {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaTopicCreatorService.class.getName());

    private String getCn() {
        return JTSolvKafkaTopicCreatorService.class.getName();
    }

    public  void createTopic(
            String pbootstrapServers,
            String ptopicName) {
        String mtd = getCn() + ":createTopic:";
        dbg(mtd + "start");
        // Define Kafka broker address (MicroK8s Node IP)
        String bootstrapServers = "192.168.55.105:10992";
        if(!StringUtils.isEmpty(pbootstrapServers)){
            bootstrapServers = pbootstrapServers;
        }
        String topicName = "jtsolv-fafka-on-k8s-topic-002";
        if(!StringUtils.isEmpty(ptopicName)) {
            topicName = ptopicName;
        }
        // Set admin properties
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        dbg(mtd + "Topic '" + topicName + "' start to create!");
        // Create AdminClient
        try (AdminClient adminClient = AdminClient.create(properties)) {
            // Define topic with partitions and replication factor
            NewTopic newTopic = new NewTopic(topicName, 3, (short) 1);

            // Create the topic
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            dbg(mtd + "Topic '" + topicName + "' created successfully!");
        } catch (Exception e) {
            dbg(mtd + "Error creating topic: " + e.getMessage());
            err(mtd + "Error creating topic: " + e.getMessage());
        }
    }

    private String dbg (String txt){
        logger.trace(txt);
        return txt;
    }

    private String err (String txt){
        logger.trace(txt);
        logger.error(txt);
        return txt;
    }

}
