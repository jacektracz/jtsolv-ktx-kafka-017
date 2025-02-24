package com.jtsolv.jtsolvcurr.kafkaspringoperations.configs;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JTSolvKafkaSpringConsumerConfig {

    @Value("${kafka.brokerConnect:k8s}")
    public String kafkaBrokerConnect;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        if(kafkaBrokerConnect.equals("k8s")){
            kafkaBrokerConnect="localhost:9092";
        }

        Map<String, Object> configProps = new HashMap<>();
        //configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerConnect);
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "jtsolv-group-id-0");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    @ConditionalOnProperty(name = "kafka.listeners.enabled", havingValue = "true")
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}