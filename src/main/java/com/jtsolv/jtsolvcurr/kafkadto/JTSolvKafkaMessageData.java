package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaMessageData {

    private String kafkaMessageThreadId;
    private String kafkaMessagePartitionId;
    private String kafkaMessageValue;

    public String getKafkaMessageOffsetId() {
        return kafkaMessageOffsetId;
    }

    public void setKafkaMessageOffsetId(String kafkaMessageOffsetId) {
        this.kafkaMessageOffsetId = kafkaMessageOffsetId;
    }

    private String kafkaMessageOffsetId;
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


}
