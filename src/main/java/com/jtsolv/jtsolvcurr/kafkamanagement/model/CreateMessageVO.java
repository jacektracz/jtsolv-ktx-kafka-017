package com.jtsolv.jtsolvcurr.kafkamanagement.model;


public final class CreateMessageVO {

  private int topicPartition;

  private String key;

  public int getTopicPartition() {
    return topicPartition;
  }

  public void setTopicPartition(int topicPartition) {
    this.topicPartition = topicPartition;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  private String value;

  private String topic;
}
