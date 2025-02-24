package com.jtsolv.jtsolvcurr.kafkadto;

import java.util.ArrayList;
import java.util.List;

public class JTSolvMessagesInfo {

    private List<JTSolvMessageInfo> kafkaMessages = new ArrayList<>();

    public List<JTSolvMessageInfo> getKafkaMessages() {
        return kafkaMessages;
    }

    public void setKafkaMessages(List<JTSolvMessageInfo> kafkaMessages) {
        this.kafkaMessages = kafkaMessages;
    }


}
