package examples.rabbitmq.mdb;

import com.rabbitmq.client.Channel;
import examples.rabbitmq.constant.QueueNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
class DelayMessageDrivenBean {

    @RabbitListener(queues = QueueNames.QUEUE_X_DLQ)
    public void onMessage(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        final String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("msg = {}", msg);
        channel.basicAck(tag, false);
    }

}
