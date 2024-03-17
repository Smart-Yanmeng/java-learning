//package org.example.student.service;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.example.vo.ClazzVo;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(consumerGroup = "stu1", topic = "student")
//public class StudentTopicService implements RocketMQListener<ClazzVo> {
//    @Override
//    public void onMessage(ClazzVo clazzVo) {
//        System.out.println("接收到消息：" + clazzVo.toString());
//    }
//}
