package com.jtsolv.jtsolvcurr.kafkamanagement.util;

import java.nio.ByteBuffer;

@FunctionalInterface
public interface MessageDeserializer {
  String deserializeMessage(ByteBuffer buffer);
}
