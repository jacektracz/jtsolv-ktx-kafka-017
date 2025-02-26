package com.jtsolv.jtsolvcurr.kafkadirectoperations.controllers;


import com.jtsolv.jtsolvcurr.kafkadirectoperations.services.JTSolvKafkaDirectTopicCreatorService;
import com.jtsolv.jtsolvcurr.kafkadirectoperations.services.JTSolvKafkaDirectTopicReadService;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestReadMessagesData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class JTSolvKafkaDirectTopicController {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectTopicController.class.getName());

    private final JTSolvKafkaDirectTopicCreatorService topicsCreateManager;
    private final JTSolvKafkaDirectTopicReadService topicsReadManager;

    private String getCn() {
        return JTSolvKafkaDirectTopicController.class.getName();
    }

    @Autowired
    public JTSolvKafkaDirectTopicController(
            JTSolvKafkaDirectTopicCreatorService topicsCreateManager,
            JTSolvKafkaDirectTopicReadService topicsReadManager){
        this.topicsCreateManager = topicsCreateManager;
        this.topicsReadManager = topicsReadManager;
    }

    @PostMapping("/api/jtsolv-kafka/create-topic-by-post")
    public JTSolvKafkaResultData createTopicByPost(
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId) {
        String mtd = getCn() + ":createTopicByPost:";
        dbg(mtd + "start");
        try{

            JTSolvKafkaRequestReadMessagesData dt =  new JTSolvKafkaRequestReadMessagesData();
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            JTSolvKafkaResultData result = topicsCreateManager.createTopic(dt);
            dbg(mtd + "end");
            return result;
        } catch (Exception e) {
            String msg = err(mtd + "exception", e);
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(msg);
            return resultErr;
        }
    }

    @GetMapping("/api/jtsolv-kafka/create-topic-by-get")
    public JTSolvKafkaResultData createTopicByGet(
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId) {
        String mtd = getCn() + ":createTopicByGet:";
        dbg(mtd + "start");

        try{
            JTSolvKafkaRequestReadMessagesData dt =  new JTSolvKafkaRequestReadMessagesData();
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            JTSolvKafkaResultData result = topicsCreateManager.createTopic(dt);
            dbg(mtd + "end");
            return result;
        } catch (Exception e) {
            String msg = err(mtd + "exception", e);
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(msg);
            return resultErr;
        }
    }

    @GetMapping("/api/jtsolv-kafka/read-topic-list-by-get")
    public JTSolvKafkaResultData readKafkaTopicListByGet(
            @RequestParam("server") String server) {
        String mtd = getCn() + ":readKafkaTopicListByGet:";
        dbg(mtd + "start");

        try{
            JTSolvKafkaRequestReadMessagesData dt =  new JTSolvKafkaRequestReadMessagesData();
            dt.setKafkaServer(server);
            JTSolvKafkaResultData resultOk = topicsReadManager.readTopics(dt);
            resultOk.setResultCode("500");
            dbg(mtd + "end");
            return resultOk;
        } catch (Exception e) {
            String msg = err(mtd + "exception", e);
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(msg);
            return resultErr;
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