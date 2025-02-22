package com.jtsolv.jtsolvcurr.kafkadto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class JTSolvKafkaThreadsData {

    private static Logger logger = LoggerFactory.getLogger(JTSolvKafkaThreadsData.class.getName());

    private ConcurrentHashMap<String, JTSolvKafkaSpringThreadData> threads = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, JTSolvKafkaSpringThreadData> getThreads() {
        return threads;
    }

    public void setThreads(ConcurrentHashMap<String, JTSolvKafkaSpringThreadData> threads) {
        this.threads = threads;
    }


    private void dbg(String txt) {
        logger.trace(txt);
    }

}
