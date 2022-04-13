package examples.rabbitmq.constant;

public final class QueueNames {

    private QueueNames() {
        super();
    }

    public static final String PREFIX_MIRROR2 = "mirror2.";

    public static final String QUEUE_X = PREFIX_MIRROR2 + "queue.x";

    public static final String QUEUE_X_DLQ = PREFIX_MIRROR2 + "queue.x.dlq";

}
