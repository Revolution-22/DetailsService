package com.revolution.details.service.infrastructure.configuration;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    ConsumerFactory<String, Object> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {

        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}
