package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaMessageData {

    private String kafkaMessageThreadId;
    private String kafkaMessagePartitionId;
    private String kafkaMessageValue;
    private String kafkaMessageKey;


    private String kafkaMessageTopic;
    private String kafkaMessageOffsetId;
    private String kafkaMessageGroupId;
    private String kafkaMessageMemberId;
    private String kafkaMessageTimestamp;

    public String getKafkaMessageResults() {
        return kafkaMessageResults;
    }

    public void setKafkaMessageResults(String kafkaMessageResults) {
        this.kafkaMessageResults = kafkaMessageResults;
    }

    public String getKafkaMessageErrorMessage() {
        return kafkaMessageErrorMessage;
    }

    public void setKafkaMessageErrorMessage(String kafkaMessageErrorMessage) {
        this.kafkaMessageErrorMessage = kafkaMessageErrorMessage;
    }

    private String kafkaMessageResults;
    private String kafkaMessageErrorMessage;

    public String getKafkaMessageGenerationId() {
        return kafkaMessageGenerationId;
    }

    public void setKafkaMessageGenerationId(String kafkaMessageGenerationId) {
        this.kafkaMessageGenerationId = kafkaMessageGenerationId;
    }

    private String kafkaMessageGenerationId;

    public String getKafkaMessageMemberId() {
        return kafkaMessageMemberId;
    }

    public void setKafkaMessageMemberId(String kafkaMessageMemberId) {
        this.kafkaMessageMemberId = kafkaMessageMemberId;
    }

    public String getKafkaMessageGroupId() {
        return kafkaMessageGroupId;
    }

    public void setKafkaMessageGroupId(String kafkaMessageGroupId) {
        this.kafkaMessageGroupId = kafkaMessageGroupId;
    }

    public String getKafkaMessageKey() {
        return kafkaMessageKey;
    }

    public void setKafkaMessageKey(String kafkaMessageKey) {
        this.kafkaMessageKey = kafkaMessageKey;
    }


    public String getKafkaMessageOffsetId() {
        return kafkaMessageOffsetId;
    }

    public void setKafkaMessageOffsetId(String kafkaMessageOffsetId) {
        this.kafkaMessageOffsetId = kafkaMessageOffsetId;
    }


    public String getKafkaMessageThreadId() {
        return kafkaMessageThreadId;
    }

    public void setKafkaMessageThreadId(String kafkaMessageThreadId) {
        this.kafkaMessageThreadId = kafkaMessageThreadId;
    }

    public String getKafkaMessagePartitionId() {
        return kafkaMessagePartitionId;
    }

    public void setKafkaMessagePartitionId(String kafkaMessagePartitionId) {
        this.kafkaMessagePartitionId = kafkaMessagePartitionId;
    }

    public String getKafkaMessageValue() {
        return kafkaMessageValue;
    }

    public void setKafkaMessageValue(String kafkaMessageValue) {
        this.kafkaMessageValue = kafkaMessageValue;
    }

    public String getKafkaMessageTopic() {
        return kafkaMessageTopic;
    }

    public void setKafkaMessageTopic(String kafkaMessageTopic) {
        this.kafkaMessageTopic = kafkaMessageTopic;
    }
    public String getKafkaMessageTimestamp() {
        return kafkaMessageTimestamp;
    }

    public void setKafkaMessageTimestamp(String kafkaMessageTimestamp) {
        this.kafkaMessageTimestamp = kafkaMessageTimestamp;
    }

}
