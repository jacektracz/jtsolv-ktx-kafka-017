package com.jtsolv.jtsolvcurr.kafkaoperations;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaTopicCreator {


    public static void main(String[] args) {
        // Define Kafka broker address (MicroK8s Node IP)
        String bootstrapServers = "192.168.55.105:10992";
        String topicName = "jtsolv-fafka-on-k8s-topic-002";

        // Set admin properties
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        System.out.println("Topic '" + topicName + "' start to create!");
        // Create AdminClient
        try (AdminClient adminClient = AdminClient.create(properties)) {
            // Define topic with partitions and replication factor
            NewTopic newTopic = new NewTopic(topicName, 3, (short) 1);

            // Create the topic
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic '" + topicName + "' created successfully!");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error creating topic: " + e.getMessage());
        }
    }


}
