package com.york.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerTest {

    public static void main(String[] args) {

        // 创建配置对象
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // 对生产的数据 K, V 进行序列化
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 创建生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configMap);

        ProducerRecord<String, String> record = new ProducerRecord<>("YORK_TOPIC", "name", "york");

        kafkaProducer.send(record);

        kafkaProducer.close();
    }
}
