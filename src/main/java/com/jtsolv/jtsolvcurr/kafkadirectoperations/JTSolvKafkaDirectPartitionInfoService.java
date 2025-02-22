package com.jtsolv.jtsolvcurr.kafkadirectoperations;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class JTSolvKafkaDirectPartitionInfoService {

    public static void main(String[] args) {
        getInfoForTopic("jtsolv-raw-topic--002");
        getInfoForTopic("topic-repl-4");
    }

    public static void getInfoForTopic(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.55.103:9092");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());

        try (AdminClient adminClient = AdminClient.create(props)) {
            // Specify the topic to describe
            // Describe the topic to get partition details
            DescribeTopicsResult result = adminClient.describeTopics(java.util.Collections.singletonList(topicName));
            KafkaFuture<Map<String, TopicDescription>> futureMap = result.all();
            
            // Retrieve and print partition information
            TopicDescription topicDescription = futureMap.get().get(topicName);
            topicDescription.partitions().forEach(partition -> {

                String hosts = partition.isr().stream()
                        .map( t -> "|h:" + t.host()
                                + " id:" + t.id()
                                + " port:" + t.port() )
                        .collect(Collectors.joining("|"));

                System.out.println(
                        "Topic:" + topicName +
                        " Partition "
                                + partition.partition()
                                + " is located on broker leader:"
                                + partition.leader()
                                + " hosts:" + hosts);

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
