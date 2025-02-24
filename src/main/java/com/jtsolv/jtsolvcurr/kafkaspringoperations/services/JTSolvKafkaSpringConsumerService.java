package com.jtsolv.jtsolvcurr.kafkaspringoperations.services;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaPartitionData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaSpringThreadData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaThreadsData;
import com.jtsolv.jtsolvcurr.kafkadto.JTSolvKafkaThreadsDataHandler;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class JTSolvKafkaSpringConsumerService {

    private final KafkaListenerEndpointRegistry registry;

    @Autowired
    public JTSolvKafkaSpringConsumerService(KafkaListenerEndpointRegistry registry){
        this.registry= registry;
    }

    public void stopListener(String id) {
        registry.getListenerContainer(id).stop();
    }

    public void startListener(String id) {
        registry.getListenerContainer(id).start();
    }

    private ReentrantLock lock = new ReentrantLock();

    private JTSolvKafkaThreadsData threadsData = new JTSolvKafkaThreadsData();

    @KafkaListener(
            id="jtsolv-lisener-001",
            topics = "jtsolv-topic-repl-4",
            groupId = "jtsolv-group-id-4",
            concurrency = "10",
            autoStartup = "false")
    public void listen(String message) {
        handleMessageThreadSafe( message,"","");
    }

    @KafkaListener(id="jtsolv-lisener-002",
            topics = "jtsolv-topic-repl-4-not-exec",
            groupId = "jtsolv-group-id-5",
            autoStartup = "false")
    public void listen(@Header("kafka_receivedPartitionId") int partition,
                       @Header("kafka_receivedOffset") long offset,
                       String message) {
        handleMessageThreadSafe( message,
                String.valueOf(partition),
                String.valueOf(offset));
    }

    @KafkaListener(
            id="jtsolv-lisener-003",
            topics = "jtsolv-t-1-bckp",
            groupId = "jtsolv-group-id-6",
            concurrency = "10",
            autoStartup = "false")
    public void listen(Message<String> message) {
        String payload = message.getPayload();
        Integer partition = message.getHeaders().get("kafka_receivedPartitionId", Integer.class);
        handleMessageThreadSafe( message.getPayload(), String.valueOf(partition),"NO-OFFSET-INFO");
    }

    @KafkaListener(
            id="jtsolv-lisener-004",
            topics = "jtsolv-topic-repl-4",
            groupId = "jtsolv-group-id-7",
            concurrency = "10",
            autoStartup = "false")
    public void listen(ConsumerRecord<String, String> record) {
        String message = record.value();
        int partition = record.partition();
        long offset = record.offset();
        handleMessageThreadSafe( message, String.valueOf(partition),String.valueOf(offset));
    }

    @KafkaListener(
            id="jtsolv-lisener-005",
            topics = "jtsolv-topic-repl-4",
            groupId = "jtsolv-group-id-8",
            autoStartup = "false")
    public void listen(@Header("kafka_receivedPartitionId") int partition, String message) {
        handleMessageThreadSafe( message ,String.valueOf(partition),"");
        dbg("Message Partition: " + partition);
    }

    private void handleMessageThreadSafe(String message,
                                         String partition,
                                         String offset) {
        lock.lock();
        try {
            handleMessageNoThreadSafe(message, partition, offset);
        } finally {
            lock.unlock();
        }
    }

    private void handleMessageNoThreadSafe(String message,
                                           String partition,
                                           String offset) {
        dbg("");
        dbg("");
        dbg("");
        dbg("Received message: " + message);
        dbg("Thread.currentThread().getName(): " + Thread.currentThread().getName());
        dbg("Thread.currentThread().getId(): " + Thread.currentThread().getId());
        dbg("Thread.currentThread().getThreadGroup(): " + Thread.currentThread().getThreadGroup());
        dbg("Thread.activeCount()(): " + Thread.activeCount());
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            dbg("Exception(): " + e.getMessage());

        }
        dbg("");
        dbg("");
        dbg("Threads ( start ):");

        JTSolvKafkaThreadsDataHandler.addThreadDataToStorage(
                threadsData.getThreads(),
                String.valueOf(Thread.currentThread().getId()),
                partition,
                offset);

        printThreads();

        dbg("Threads ( end ):");
        dbg("");
        dbg("");
        dbg("");

    }

    private void dbg(String txt) {
        System.out. println(txt);
    }

    private void printThreads() {
        threadsData.getThreads()
            .entrySet()
            .stream()
            .forEach(this::printEntry);
    }

    private void printEntry(Map.Entry<String, JTSolvKafkaSpringThreadData> entry) {

        dbg("");
        dbg("");
        dbg("-------------- THREAD (start) ------------------");
        dbg("Thread id: " + entry.getKey());
        JTSolvKafkaSpringThreadData ktd = entry.getValue();
        dbg("Messages count: " + ktd.getMessagesCount());
        dbg("Thread data id: " + ktd.getThreadId());
        dbg("Partitions count: " + ktd.getPartitions().entrySet().stream().count());

        ktd.getPartitions()
                .entrySet()
                .stream()
                .forEach(t -> printPartition(t, ktd.getThreadId()));

        dbg("-------------- THREAD (end) ------------------");
        dbg("");
        dbg("");
    }

    private void printPartition(Map.Entry<String, JTSolvKafkaPartitionData> entry, String threadId) {
        JTSolvKafkaPartitionData partition = entry.getValue();
        dbg("[Thread:" + threadId +  "][Partition: " + partition.getKafkaPartitionPartitionId() + "]");
        partition.getOffsets()
                .entrySet()
                .stream()
                .forEach(t -> printOffset(t,
                        threadId,
                        partition.getKafkaPartitionPartitionId()));

    }

    private void printOffset(
            Map.Entry<String, String> entry,
            String threadId,
            String partitionId) {

        dbg("[Thread:" + threadId +  "]"
                + "[Partition: " + partitionId + "]"
                + "[Offset:" + entry.getValue() + "]");

    }

}