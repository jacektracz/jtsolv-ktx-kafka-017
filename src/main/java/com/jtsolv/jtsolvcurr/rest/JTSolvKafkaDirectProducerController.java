package com.jtsolv.jtsolvcurr.rest;


import com.jtsolv.jtsolvcurr.kafkadirectoperations.JTSolvKafkaDirectProducerService;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JTSolvKafkaDirectProducerController {

    @Autowired
    private JTSolvKafkaDirectProducerService messageProducer;

    @PostMapping("/kafka/send-direct-post")
    public JTSolvKafkaResultData sendMessage(
            @RequestParam("message") String topic,
            @RequestParam("message") String message,
            @RequestParam("numbers") String numbers) {
        try{
            JTSolvKafkaRequestData dt  = new JTSolvKafkaRequestData();
            dt.setTopic(topic);
            dt.setMessageValue(message);
            dt.setNumbers(numbers);
            JTSolvKafkaResultData result = messageProducer.produceMessage(dt);
            result.setResultCode("200");
            return result;
        } catch (Exception e) {
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }
    }

    @GetMapping("/kafka/send-direct-get")
    public JTSolvKafkaResultData sendMessageGet(
            @RequestParam("message") String topic,
            @RequestParam("message") String message,
            @RequestParam("numbers") String numbers) {

        try{
            JTSolvKafkaRequestData dt  = new JTSolvKafkaRequestData();
            dt.setTopic(topic);
            dt.setMessageValue(message);
            dt.setNumbers(numbers);
            JTSolvKafkaResultData result = messageProducer.produceMessage(dt);
            result.setResultCode("200");
            return result;
        } catch (Exception e) {
            JTSolvKafkaResultData resultErr = new JTSolvKafkaResultData();
            resultErr.setResultCode("500");
            resultErr.setResultErrorMessage(e.getMessage());
            return resultErr;
        }
    }

}