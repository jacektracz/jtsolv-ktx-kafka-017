package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaTopicData {

    private String topicValue;

    public JTSolvKafkaTopicData(String value){
        this.topicValue = value;
    }

    public String getTopicValue() {
        return topicValue;
    }

    public void setTopicValue(String topicValue) {
        this.topicValue = topicValue;
    }

}
