package examples.kafka.partition;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * 仅用于测试和演示，生产上无意义
 */
@Slf4j
public final class LoggingPartitioner implements Partitioner {

    private final static Partitioner DEFAULT = new DefaultPartitioner();

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        log.debug("topic = {} key = {}, value = {}", topic, key, value);
        return DEFAULT.partition(topic, key, keyBytes, value, valueBytes, cluster);
    }

    @Override
    public void close() {
        DEFAULT.close();
    }

    @Override
    public void configure(Map<String, ?> configs) {
        DEFAULT.configure(configs);
    }

    @Override
    public void onNewBatch(String topic, Cluster cluster, int prevPartition) {
        DEFAULT.onNewBatch(topic, cluster, prevPartition);
    }

}
