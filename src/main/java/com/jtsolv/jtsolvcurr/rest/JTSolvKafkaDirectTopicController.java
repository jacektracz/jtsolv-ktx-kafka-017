package com.jtsolv.jtsolvcurr.rest;


import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectTopicCreatorService;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JTSolvKafkaDirectTopicController {

    private final JTSolvKafkaDirectTopicCreatorService topicsManager;

    @Autowired
    public JTSolvKafkaDirectTopicController(
            JTSolvKafkaDirectTopicCreatorService messageConsumer){
        this.topicsManager = messageConsumer;
    }

    @PostMapping("/kafka/create-topic-post")
    public JTSolvKafkaResultData createTopicByPost(
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId) {
        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            JTSolvKafkaResultData result = topicsManager.createTopic(dt);
            return result;
        } catch (Exception e) {
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }
    }

    @GetMapping("/kafka/create-topic-get")
    public JTSolvKafkaResultData createTopicByGet(
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId) {
        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            JTSolvKafkaResultData result = topicsManager.createTopic(dt);
            return result;
        } catch (Exception e) {
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }
    }
}