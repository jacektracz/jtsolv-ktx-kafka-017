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
public class JTSolvKafkaDirectProducerController {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaDirectProducerController.class.getName());

    private final JTSolvKafkaDirectProducerService messageProducer;

    @Autowired
    public JTSolvKafkaDirectProducerController(JTSolvKafkaDirectProducerService messageProducer){
        this.messageProducer = messageProducer;
    }

    private String getCn() {
        return JTSolvKafkaDirectProducerController.class.getName();
    }

    @PostMapping("/api/jtsolv-kafka/send-message-direct-by-post")
    public JTSolvKafkaResultData sendMessageByPost(
            @RequestParam("server") String server,
            @RequestParam("topic") String topic,
            @RequestParam("message") String message,
            @RequestParam("numbers") String numbers) {

        String mtd = getCn() + ":sendMessageByPost:";
        dbg(mtd + "start");
        try{
            JTSolvKafkaRequestData dt  = new JTSolvKafkaRequestData();
            dt.setKafkaServer(server);
            dt.setBrokerId(server);
            dt.setTopic(topic);
            dt.setMessageValue(message);
            dt.setNumbers(numbers);
            JTSolvKafkaResultData result = messageProducer.produceMessage(dt);
            result.setResultCode("200");
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

    @GetMapping("/api/jtsolv-kafka/send-message-direct-by-get")
    public JTSolvKafkaResultData sendMessageByGet(
            @RequestParam("server") String server,
            @RequestParam("topic") String topic,
            @RequestParam("message") String message,
            @RequestParam("numbers") String numbers) {
        String mtd = getCn() + ":sendMessageByGet:";
        dbg(mtd + "start");
        try{
            JTSolvKafkaRequestData dt  = new JTSolvKafkaRequestData();
            dt.setKafkaServer(server);
            dt.setBrokerId(server);
            dt.setTopic(topic);
            dt.setMessageValue(message);
            dt.setNumbers(numbers);
            JTSolvKafkaResultData result = messageProducer.produceMessage(dt);
            result.setResultCode("200");
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