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

    private final JTSolvKafkaDirectProducerService messageProducer;

    @Autowired
    public JTSolvKafkaDirectProducerController(JTSolvKafkaDirectProducerService messageProducer){
        this.messageProducer = messageProducer;
    }

    @PostMapping("/api/jtsolv-kafka/send-message-direct-by-post")
    public JTSolvKafkaResultData sendMessage(
            @RequestParam("server") String server,
            @RequestParam("message") String topic,
            @RequestParam("message") String message,
            @RequestParam("numbers") String numbers) {
        try{
            JTSolvKafkaRequestData dt  = new JTSolvKafkaRequestData();
            dt.setKafkaServer(server);
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

    @GetMapping("/api/jtsolv-kafka/send-message-direct-by-get")
    public JTSolvKafkaResultData sendMessageGet(
            @RequestParam("server") String server,
            @RequestParam("message") String topic,
            @RequestParam("message") String message,
            @RequestParam("numbers") String numbers) {

        try{
            JTSolvKafkaRequestData dt  = new JTSolvKafkaRequestData();
            dt.setKafkaServer(server);
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