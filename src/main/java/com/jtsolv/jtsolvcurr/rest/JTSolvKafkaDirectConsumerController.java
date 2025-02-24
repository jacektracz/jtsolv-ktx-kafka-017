package com.jtsolv.jtsolvcurr.rest;


import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectConsumerService;
import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectProducerService;
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
public class JTSolvKafkaDirectConsumerController {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectConsumerController.class.getName());

    private final JTSolvKafkaDirectConsumerService messageConsumer;

    @Autowired
    public JTSolvKafkaDirectConsumerController(JTSolvKafkaDirectConsumerService messageConsumer){
        this.messageConsumer = messageConsumer;
    }

    private String getCn() {
        return JTSolvKafkaDirectProducerController.class.getName();
    }

    @PostMapping("/api/jtsolv-kafka/read-messge-direct-by-post")
    public JTSolvKafkaResultData readMessageByPost(
            @RequestParam("groupId") String groupId,
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId,
            @RequestParam("numbers") String numbers,
            @RequestParam("startoffset") String startoffset,
            @RequestParam("endoffset") String endoffset,
            @RequestParam("pooltime") String pooltime) {
        String mtd = getCn() + ":readMessageByPost:";
        dbg(mtd + "start");

        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setGroupId(groupId);
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            dt.setNumbers(numbers);
            dt.setStartoffset(startoffset);
            dt.setEndoffset(endoffset);
            dt.setThreadKafkaPoolingTime(pooltime);
            JTSolvKafkaResultData result = messageConsumer.consumeMessage(dt);
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

    @GetMapping("/api/jtsolv-kafka/read-message-direct-by-get")
    public JTSolvKafkaResultData readMessageByGet(
            @RequestParam("groupId") String groupId,
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId,
            @RequestParam("numbers") String numbers,
            @RequestParam("startoffset") String startoffset,
            @RequestParam("endoffset") String endoffset,
            @RequestParam("pooltime") String pooltime) {

        String mtd = getCn() + ":readMessageByGet:";
        dbg(mtd + "start");

        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setGroupId(groupId);
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            dt.setNumbers(numbers);
            dt.setStartoffset(startoffset);
            dt.setEndoffset(endoffset);
            dt.setThreadKafkaPoolingTime(pooltime);
            JTSolvKafkaResultData result = messageConsumer.consumeMessage(dt);
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