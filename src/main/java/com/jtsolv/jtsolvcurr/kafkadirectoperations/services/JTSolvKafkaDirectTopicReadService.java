package com.jtsolv.jtsolvcurr.kafkadirectoperations.services;

import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestReadMessagesData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaTopicData;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JTSolvKafkaDirectTopicReadService {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectTopicReadService.class.getName());

    private String getCn() {
        return JTSolvKafkaDirectTopicReadService.class.getName();
    }

    public JTSolvKafkaResultData readTopics(JTSolvKafkaRequestReadMessagesData dt) {
        String mtd = getCn() + ":readTopics:";
        dbg(mtd + "start");
        JTSolvKafkaResultData resultOk = new JTSolvKafkaResultData();
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, dt.getKafkaServer());

        // Create AdminClient
        try (AdminClient adminClient = AdminClient.create(props)) {
            // Fetch topic names
            ListTopicsResult topics = adminClient.listTopics();
            Set<String> topicNames = topics.names().get();
            dbg("Kafka Topics: " + topics.names().get());
            List<JTSolvKafkaTopicData> topicsData = topicNames
                    .stream()
                    .map(t -> new JTSolvKafkaTopicData(t))
                    .collect(Collectors.toList());
            resultOk.setResultTopics(topicsData);
            dbg(mtd + "end-method");
            resultOk.setResultCode("200");
            return resultOk;
        } catch (Exception e) {
            JTSolvKafkaResultData resultError = new JTSolvKafkaResultData();
            dbg(mtd + "Error read topics: " + e.getMessage());
            resultError.setResultErrorMessage(
                    err(mtd + "Error read topic: ", e));
            resultError.setResultCode("500");
            return resultError;
        }
    }

    private String dbg(String txt) {
        JTSolvStaticExtenderLogger.logGenericInfo(logger, txt);
        return txt;
    }

    private String err(String txt, Exception ex) {
        JTSolvStaticExtenderLogger.logGenericInfo(logger, txt);
        String txtOut = JTSolvStaticExtenderLogger.logGenericException(logger, ex, txt);
        return txtOut;
    }

}
