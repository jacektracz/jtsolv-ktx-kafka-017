package com.jtsolv.jtsolvcurr.rest;


import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectConsumerService;
import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectProducerService;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JTSolvKafkaDirectConsumerController {

    private final JTSolvKafkaDirectConsumerService messageConsumer;

    @Autowired
    public JTSolvKafkaDirectConsumerController(JTSolvKafkaDirectConsumerService messageConsumer){
        this.messageConsumer = messageConsumer;
    }

    @PostMapping("/jtsolv-kafka/read-messge-direct-by-post")
    public JTSolvKafkaResultData readMessage(
            @RequestParam("groupId") String groupId,
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId,
            @RequestParam("numbers") String numbers,
            @RequestParam("startoffset") String startoffset,
            @RequestParam("endoffset") String endoffset) {
        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setGroupId(groupId);
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            dt.setNumbers(numbers);
            dt.setStartoffset(startoffset);
            dt.setEndoffset(endoffset);
            JTSolvKafkaResultData result = messageConsumer.consumeMessage(dt);
            return result;
        } catch (Exception e) {
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }
    }

    @GetMapping("/jtsolv-kafka/read-message-direct-by-get")
    public JTSolvKafkaResultData sendMessageGet(
            @RequestParam("groupId") String groupId,
            @RequestParam("topic") String topic,
            @RequestParam("brokerId") String brokerId,
            @RequestParam("numbers") String numbers,
            @RequestParam("startoffset") String startoffset,
            @RequestParam("endoffset") String endoffset) {

        try{
            JTSolvKafkaRequestData dt =  new JTSolvKafkaRequestData();
            dt.setGroupId(groupId);
            dt.setTopic(topic);
            dt.setBrokerId(brokerId);
            dt.setNumbers(numbers);
            dt.setStartoffset(startoffset);
            dt.setEndoffset(endoffset);
            JTSolvKafkaResultData result = messageConsumer.consumeMessage(dt);
            return result;
        } catch (Exception e) {
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }

    }
}