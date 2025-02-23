package com.jtsolv.jtsolvcurr.rest;


import com.jtsolv.jtsolvcurr.kafkaspringoperations.JTSolvKafkaSpringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JTSolvKafkaSpringProducerController {

    @Autowired
    private JTSolvKafkaSpringProducerService messageProducer;

    @PostMapping("/jtsolv-kafka/send-message-spring-by-post")
    public String sendMessage(@RequestParam("message") String topic,
                              @RequestParam("message") String message) {
        messageProducer.sendMessage("jtsolv-test-topic-4", message);
        return "Message sent: " + message;
    }

    @GetMapping("/jtsolv-kafka/send-message-spring-by-get")
    public String sendMessageGet(@RequestParam("message") String topic, @RequestParam("message") String message) {
        messageProducer.sendMessage(topic, message);
        return "Message sent: " + message;
    }

}