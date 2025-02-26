package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaRequestWriteMessagesData {

    private String topic;
    private String brokerId;
    private String server;
    private String messageWriteNumbers = "1";
    private String keyPrefix = "jtsolv-";
    private JTSolvKafkaMessageBodyData messageBody =  new JTSolvKafkaMessageBodyData("");

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }


    public String getMessageWriteNumbers() {
        return messageWriteNumbers;
    }

    public void setMessageWriteNumbers(String messageWriteNumbers) {
        this.messageWriteNumbers = messageWriteNumbers;
    }
    public JTSolvKafkaMessageBodyData getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(JTSolvKafkaMessageBodyData messageBody) {
        this.messageBody = messageBody;
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


}
