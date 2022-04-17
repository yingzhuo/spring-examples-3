package examples.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class ConsumerBean {

    private static final String GROUP_ID = "spring-examples";

//    @KafkaListener(
//            topics = "test_topic",
//            groupId = GROUP_ID,
//            topicPartitions = @TopicPartition(topic = "test_topic", partitions = {"0"}),
//            containerFactory = "kafkaManualAckListenerContainerFactory"
//    )
//    public void listen(@Payload ConsumerRecord<String, String> record, Acknowledgment ack) {
//        log.debug("received message | group ({}) partition({}) | {}", GROUP_ID, record.partition(), record.value());
//        ack.acknowledge();
//        ack.nack(1000L);
//    }

    @KafkaListener(
            topics = "test_topic",
            groupId = GROUP_ID,
//            topicPartitions = @TopicPartition(topic = "test_topic", partitions = {"0"}),
            containerFactory = "kafkaManualAckListenerContainerFactory"
    )
    public void listenBatch(List<String> messages, Acknowledgment ack) {

        final String batchId = UUID.randomUUID().toString();

        for (String message : messages) {
            log.debug("received message | batch-id ({}) | group ({}) | {}", batchId, GROUP_ID, message);
        }

        ack.acknowledge();
//        ack.nack(1000L);
    }

}
