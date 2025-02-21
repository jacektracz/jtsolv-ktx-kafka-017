package com.jtsolv.jtsolvcurr.kafkamanagement.util;

@FunctionalInterface
public interface MessageSerializer {
  byte[] serializeMessage(String value);
}
