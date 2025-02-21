package com.jtsolv.jtsolvcurr.kafkamanagement.util;

public class DefaultMessageSerializer implements MessageSerializer {

  @Override
  public byte[] serializeMessage(String value) {
    return value.getBytes();
  }

}
