package com.york.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.time.Duration.ofMillis;

public class KafkaConsumerTest {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        // 创建配置对象
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // 对消费的数据 K, V 进行反序列化
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "YORK_GROUP");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(configMap);

        kafkaConsumer.subscribe(Collections.singletonList("YORK_TOPIC"));

        while (true) {
            kafkaConsumer.poll(ofMillis(1000)).forEach(
                    record -> System.out.println("key: " + record.key() + ", value: " + record.value())
            );
        }
    }
}
