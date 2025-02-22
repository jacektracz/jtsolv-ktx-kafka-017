package com.jtsolv.jtsolvcurr.kafkadto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class JTSolvKafkaThreadsDataHandler {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaThreadsDataHandler.class.getName());

    public static void addThreadDataToStorage(
            ConcurrentHashMap<String, JTSolvKafkaSpringThreadData> threads,
            String threadId,
            String partition,
            String offset) {
        if( threads.containsKey(threadId) ){
            dbg("Update message info ( start )");
            JTSolvKafkaSpringThreadData ktd = threads.get(threadId);
            dbg("Update partition data:" + partition);
            ktd.addPartition(partition);
            dbg("Ktd thread id:" + ktd.getThreadId());
            dbg("Messages count:" + ktd.getMessagesCount());
            int mc = ktd.getMessagesCount() + 1;
            ktd.setMessagesCount( mc );
            ktd.addOffset(partition,offset);
            dbg("Messages count inc:" + ktd.getMessagesCount());
            dbg("Update message info ( end )");
        }else {
            dbg("Add message info ( start )");
            JTSolvKafkaSpringThreadData ktd = new JTSolvKafkaSpringThreadData();
            ktd.setThreadId(threadId);
            ktd.addPartition(partition);
            ktd.setMessagesCount( 1 );
            ktd.addOffset(partition, offset);
            threads.putIfAbsent(threadId, ktd);
            dbg("Add message info ( end )");
        }

    }

    private static void dbg(String txt) {
        logger.trace(txt);
    }

}
