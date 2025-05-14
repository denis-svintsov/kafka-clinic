package org.example.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.dto.Appointment;
import org.example.dto.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Client> clientProducerFactory() {
        return new DefaultKafkaProducerFactory<>(commonConfigs());
    }

    @Bean
    public KafkaTemplate<String, Client> clientKafkaTemplate() {
        return new KafkaTemplate<>(clientProducerFactory());
    }

    @Bean
    public ProducerFactory<String, Appointment> orderProducerFactory() {
        return new DefaultKafkaProducerFactory<>(commonConfigs());
    }

    @Bean
    public KafkaTemplate<String, Appointment> orderKafkaTemplate() {
        return new KafkaTemplate<>(orderProducerFactory());
    }

    private Map<String, Object> commonConfigs() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return config;
    }
}
