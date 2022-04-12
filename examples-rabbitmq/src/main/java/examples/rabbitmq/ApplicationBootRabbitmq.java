package examples.rabbitmq;

import examples.rabbitmq.constant.ExchangeNames;
import examples.rabbitmq.constant.QueueNames;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ApplicationBootRabbitmq {

    // 一般队列
    @Bean(name = QueueNames.QUEUE_X)
    Queue queueX() {
        return QueueBuilder.durable(QueueNames.QUEUE_X)
                .deadLetterExchange(ExchangeNames.DEFAULT)
                .deadLetterRoutingKey(QueueNames.QUEUE_X_DLQ)
                .ttl(5000)
                .build();
    }

    // 死信队列
    @Bean(name = QueueNames.QUEUE_X_DLQ)
    Queue queueXDlq() {
        return QueueBuilder.durable(QueueNames.QUEUE_X_DLQ)
                .build();
    }

}
