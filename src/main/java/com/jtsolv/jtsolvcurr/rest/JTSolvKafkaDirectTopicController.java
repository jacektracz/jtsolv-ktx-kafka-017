package com.jtsolv.jtsolvcurr.rest;


import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectConsumerService;
import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectTopicCreatorService;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JTSolvKafkaDirectTopicController {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectConsumerService.class.getName());

    private final JTSolvKafkaDirectTopicCreatorService topicsManager;

    private String getCn() {
        return JTSolvKafkaDirectTopicController.class.getName();
    }

    @Autowired
    public JTSolvKafkaDirectTopicController(
            JTSolvKafkaDirectTopicCreatorService messageConsumer){
        this.topicsManager = messageConsumer;
    }

    @PostMapping("/jtsolv-kafka/create-topic-by-post")
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

    @GetMapping("/jtsolv-kafka/create-topic-by-get")
    public JTSolvKafkaResultData createTopicByGet(
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId) {
        String mtd = getCn() + ":createTopicByGet:";
        dbg(mtd + "start");

        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            JTSolvKafkaResultData result = topicsManager.createTopic(dt);
            dbg(mtd + "end");
            return result;
        } catch (Exception e) {
            err(mtd + "start",e);
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }
    }

    private String dbg (String txt){
        JTSolvStaticExtenderLogger.logGenericInfo(logger,txt);
        return txt;
    }

    private String err (String txt,Exception ex){
        JTSolvStaticExtenderLogger.logGenericInfo(logger,txt);
        JTSolvStaticExtenderLogger.logGenericException(logger,ex,txt);
        return txt;
    }

}