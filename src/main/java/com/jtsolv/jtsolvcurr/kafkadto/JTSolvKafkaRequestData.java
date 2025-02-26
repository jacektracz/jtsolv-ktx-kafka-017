package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaRequestData {

    private String groupId;
    private String topic;
    private String messageValue;
    private String brokerId;
    private String messageNumbers;
    private String numberOfPoolIterations="10";
    private String startoffset;
    private String endoffset;
    private String threadSleepBetweenPoolingIterations = "1000";
    private String threadKafkaPoolingTime = "10000";
    private String keyPrefix= "";
    private String kafkaServer = "192.168.55.103:9092";

    public JTSolvKafkaMessageBodyData getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(JTSolvKafkaMessageBodyData messageBody) {
        this.messageBody = messageBody;
    }

    private JTSolvKafkaMessageBodyData messageBody = new JTSolvKafkaMessageBodyData("");

    public String getKafkaServer() {
        return kafkaServer;
    }

    public void setKafkaServer(String kafkaServer) {
        this.kafkaServer = kafkaServer;
    }


    public String getThreadKafkaPoolingTime() {
        return threadKafkaPoolingTime;
    }

    public void setThreadKafkaPoolingTime(String threadKafkaPoolingTime) {
        this.threadKafkaPoolingTime = threadKafkaPoolingTime;
    }



    public String getThreadSleepBetweenPoolingIterations() {
        return threadSleepBetweenPoolingIterations;
    }

    public void setThreadSleepBetweenPoolingIterations(String threadSleepBetweenPoolingIterations) {
        this.threadSleepBetweenPoolingIterations = threadSleepBetweenPoolingIterations;
    }


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

    public String getMessageNumbers() {
        return messageNumbers;
    }

    public void setMessageNumbers(String messageNumbers) {
        this.messageNumbers = messageNumbers;
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

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
    public String getNumberOfPoolIterations() {
        return numberOfPoolIterations;
    }

    public void setNumberOfPoolIterations(String numberOfPoolIterations) {
        this.numberOfPoolIterations = numberOfPoolIterations;
    }

}
