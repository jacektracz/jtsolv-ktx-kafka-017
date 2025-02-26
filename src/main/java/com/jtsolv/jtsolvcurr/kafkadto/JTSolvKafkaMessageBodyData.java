package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaMessageBodyData {

    private String messageBodyValue;
    public JTSolvKafkaMessageBodyData() {}
    public JTSolvKafkaMessageBodyData(String value){
        this.messageBodyValue = value;
    }

    public String getMessageBodyValue() {
        return messageBodyValue;
    }

    public void setMessageBodyValue(String messageBodyValue) {
        this.messageBodyValue = messageBodyValue;
    }

}
