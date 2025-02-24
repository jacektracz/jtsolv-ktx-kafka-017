package com.jtsolv.jtsolvcurr.kafkaspringoperations.controllers;


import com.jtsolv.jtsolvcurr.kafkaspringoperations.services.JTSolvKafkaSpringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class JTSolvKafkaSpringProducerController {

    @Autowired
    private JTSolvKafkaSpringProducerService messageProducer;

    @PostMapping("/api/jtsolv-kafka/send-message-spring-by-post")
    public String sendMessage(@RequestParam("message") String topic,
                              @RequestParam("message") String message) {
        messageProducer.sendMessage("jtsolv-test-topic-4", message);
        return "Message sent: " + message;
    }

    @GetMapping("/api/jtsolv-kafka/send-message-spring-by-get")
    public String sendMessageGet(@RequestParam("message") String topic, @RequestParam("message") String message) {
        messageProducer.sendMessage(topic, message);
        return "Message sent: " + message;
    }

}