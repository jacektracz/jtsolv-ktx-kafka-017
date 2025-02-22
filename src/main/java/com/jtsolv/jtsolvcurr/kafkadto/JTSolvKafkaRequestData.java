package com.jtsolv.jtsolvcurr.kafkadto;

import org.springframework.web.bind.annotation.RequestParam;

public class JTSolvKafkaRequestData {

    private String groupId;
    private String topic;
    private String brokerId;
    private String numbers;
    private String startoffset;
    private String endoffset;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getStartoffset() {
        return startoffset;
    }

    public void setStartoffset(String startoffset) {
        this.startoffset = startoffset;
    }

    public String getEndoffset() {
        return endoffset;
    }

    public void setEndoffset(String endoffset) {
        this.endoffset = endoffset;
    }


}
