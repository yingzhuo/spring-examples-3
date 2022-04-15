package examples.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

/**
 * @see AdminClientConfig
 */
@EnableKafka
@Configuration
class ApplicationBootKafka {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaManualAckListenerContainerFactory(ConsumerFactory<String, String> consumerFactory) {
        final ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test_topic")
                .partitions(3)
                .replicas(1)
                .build();
    }

}
