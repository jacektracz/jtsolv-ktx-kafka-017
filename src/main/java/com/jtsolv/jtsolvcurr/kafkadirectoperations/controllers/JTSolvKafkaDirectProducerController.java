package com.jtsolv.jtsolvcurr.kafkadirectoperations.controllers;



import com.jtsolv.jtsolvcurr.kafkadirectoperations.services.JTSolvKafkaDirectProducerService;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaMessageBodyData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestReadMessagesData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaRequestWriteMessagesData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaResultData;
import com.jtsolv.jtsolvcurr.logging.JTSolvStaticExtenderLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
            @RequestBody JTSolvKafkaRequestWriteMessagesData dtBody) {

        String mtd = getCn() + ":sendMessageByPost:";
        dbg(mtd + "start");
        try{
            JTSolvKafkaResultData result = messageProducer.produceMessage(dtBody);
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
            @RequestParam("messagevalue") String messagevalue,
            @RequestParam("messagenumbers") String messagenumbers) {
        String mtd = getCn() + ":sendMessageByGet:";
        dbg(mtd + "start");
        try{
            JTSolvKafkaRequestWriteMessagesData dt  = new JTSolvKafkaRequestWriteMessagesData();
            dt.setServer(server);
            dt.setBrokerId(server);
            dt.setTopic(topic);
            dt.setMessageWriteNumbers(messagenumbers);
            dt.setMessageBody(new JTSolvKafkaMessageBodyData(messagevalue));
            JTSolvKafkaResultData resultOk = messageProducer.produceMessage(dt);
            resultOk.setResultCode("200");

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