package com.jtsolv.jtsolvcurr.kafkadirectoperations;

import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
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
public class JTSolvKafkaDirectTopicCreatorService {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectTopicCreatorService.class.getName());

    private String getCn() {
        return JTSolvKafkaDirectTopicCreatorService.class.getName();
    }

    public JTSolvKafkaResultData createTopic(
            JTSolvKafkaRequestData dt
            ) {
        String mtd = getCn() + ":createTopic:";
        dbg(mtd + "start");
        String pbootstrapServers = dt.getBrokerId();
        String ptopicName = dt.getTopic();
        JTSolvKafkaResultData resultOk = new JTSolvKafkaResultData();
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
            resultOk.setResultSuccessMessage(
                    dbg(mtd + "Topic '" + topicName + "' created successfully!"));
            resultOk.setResultCode("200");
            dbg(mtd + "end-method");
            return resultOk;
        } catch (Exception e) {
            JTSolvKafkaResultData resultError = new JTSolvKafkaResultData();
            dbg(mtd + "Error creating topic: " + e.getMessage());
            resultError.setResultErrorMessage(
                    err(mtd + "Error creating topic: " , e));
            resultError.setResultCode("500");
            return resultError;
        }
    }

    private String dbg (String txt){
        JTSolvStaticExtenderLogger.logGenericInfo(logger,txt);
        return txt;
    }

    private String err (String txt,Exception ex){
        JTSolvStaticExtenderLogger.logGenericInfo(logger,txt);
        String txtOut = JTSolvStaticExtenderLogger.logGenericException(logger,ex,txt);
        return txtOut;
    }

}
