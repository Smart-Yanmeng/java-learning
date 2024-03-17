//package org.example.student.service;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(consumerGroup = "stu2", topic = "student")
//public class OrderService implements RocketMQListener<String> {
//
//    @Override
//    public void onMessage(String s) {
//        System.out.println("OrderService接收到消息：" + s);
//    }
//}
