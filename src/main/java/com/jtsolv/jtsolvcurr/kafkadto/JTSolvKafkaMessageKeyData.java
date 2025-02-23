package com.jtsolv.jtsolvcurr.kafkadto;

public class JTSolvKafkaMessageKeyData {

    private String keyValue;

    public JTSolvKafkaMessageKeyData(String value){
        this.keyValue = value;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

}
