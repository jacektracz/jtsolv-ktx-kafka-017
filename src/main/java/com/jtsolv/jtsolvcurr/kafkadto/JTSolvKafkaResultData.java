package com.jtsolv.jtsolvcurr.kafkadto;

import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JTSolvKafkaResultData {

    private String resultCode = "";
    private String resultSuccessMessage = "";
    private String resultErrorMessage = "";
    private String poolThreadSleepTime = "1000";
    private List<JTSolvKafkaMessageData> resultMessages = new ArrayList<>();
    private List<JTSolvKafkaTopicData> resultTopics = new ArrayList<>();

    public JTSolvKafkaResultData() {
        this.resultCode = "";
        this.resultSuccessMessage = "";
        this.resultErrorMessage = "";
        this.resultMessages = new ArrayList<>();
        this.resultTopics = new ArrayList<>();
    }

    public List<JTSolvKafkaTopicData> getResultTopics() {
        return resultTopics;
    }

    public void setResultTopics(List<JTSolvKafkaTopicData> resultTopics) {
        this.resultTopics = resultTopics;
    }



    public String getPoolThreadSleepTime() {
        return poolThreadSleepTime;
    }

    public void setPoolThreadSleepTime(String poolThreadSleepTime) {
        this.poolThreadSleepTime = poolThreadSleepTime;
    }



    public List<JTSolvKafkaMessageData> getResultMessages() {
        return resultMessages;
    }

    public void setResultMessages(List<JTSolvKafkaMessageData> resultMessages) {
        this.resultMessages = resultMessages;
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultSuccessMessage() {
        return resultSuccessMessage;
    }

    public void setResultSuccessMessage(String resultSuccessMessage) {
        this.resultSuccessMessage = resultSuccessMessage;
    }

    public String getResultErrorMessage() {
        return resultErrorMessage;
    }

    public void setResultErrorMessage(String resultErrorMessage) {
        this.resultErrorMessage = resultErrorMessage;
    }

}
