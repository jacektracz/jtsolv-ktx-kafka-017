package com.jtsolv.jtsolvcurr.kafkadto;

import io.micrometer.common.util.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class JTSolvKafkaPartitionData {

    private String kafkaPartitionThreadId;
    private String kafkaPartitionPartitionId;
    private int kafkaPartitionMessagesCount = 0;

    public String getKafkaPartitionPartitionId() {
        return kafkaPartitionPartitionId;
    }

    public void setKafkaPartitionPartitionId(String kafkaPartitionPartitionId) {
        this.kafkaPartitionPartitionId = kafkaPartitionPartitionId;
    }

    private Map<String, String> offsets = new TreeMap();

    public Map<String, String> getOffsets() {
        return offsets;
    }

    public void setOffsets(Map<String, String> offsets) {
        this.offsets = offsets;
    }

    public int getKafkaPartitionMessagesCount() {
        return kafkaPartitionMessagesCount;
    }

    public void setKafkaPartitionMessagesCount(int kafkaPartitionMessagesCount) {
        this.kafkaPartitionMessagesCount = kafkaPartitionMessagesCount;
    }


    public String getKafkaPartitionThreadId() {
        return kafkaPartitionThreadId;
    }

    public void setKafkaPartitionThreadId(String kafkaPartitionThreadId) {
        this.kafkaPartitionThreadId = kafkaPartitionThreadId;
    }


    public void addOffset(String offset){
        if(StringUtils.isEmpty(offset)){
            return;
        }
        offsets.putIfAbsent(offset, offset);
    }

}
