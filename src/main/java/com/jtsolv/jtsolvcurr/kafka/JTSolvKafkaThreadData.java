package com.jtsolv.jtsolvcurr.kafka;



import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class JTSolvKafkaThreadData {

    private String threadId;
    private Map<String, JTSolvKafkaPartitionData> partitions = new TreeMap();
    private int messagesCount = 0;
    private Map<String, String> offsets = new TreeMap();

    public Map<String, String> getOffsets() {
        return offsets;
    }

    public void setOffsets(Map<String, String> offsets) {
        this.offsets = offsets;
    }

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }


    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }


    public Map<String, JTSolvKafkaPartitionData> getPartitions() {
        return partitions;
    }

    public void setPartitions(Map<String, JTSolvKafkaPartitionData> partitions) {
        this.partitions = partitions;
    }

    public void addPartition(String partition) {
        if(StringUtils.isEmpty(partition)){
            return;
        }
        JTSolvKafkaPartitionData kpd = new JTSolvKafkaPartitionData();
        kpd.setPartitionId(partition);
        partitions.putIfAbsent(partition, kpd);
    }

    public void addOffset(String partition,String offset){
        if(StringUtils.isEmpty(offset)){
            return;
        }
        offsets.putIfAbsent(offset, offset);
        if( partitions.containsKey(partition)){
            JTSolvKafkaPartitionData kpd = partitions.get(partition);
            kpd.addOffset(offset);
        }

    }

}
