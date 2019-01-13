package cc.databus.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MyKafkaProducer extends Thread {
    private final String topic;
    private final Properties properties;
    public MyKafkaProducer(String topic) {
        this.topic = topic;

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("delivery.timeout.ms", 40000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.properties = props;
    }

    @Override
    public void run() {
        Producer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 100; i++) {
            String key = "key-" + i;
            String msg = "msg-" + i;
            producer.send(new ProducerRecord<>(topic, key, msg));
            System.out.println("Messge sent - key: " + key + ", message: " + msg);
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(10));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }

    public static void main(String[] args) {
        new MyKafkaProducer("my-topic").start();
    }
}
