//package org.example.clazz.controller;
//
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.example.vo.ClazzVo;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping("/mqSend")
//public class MqSendController {
//
//    @Resource
//    private RocketMQTemplate rocketMQTemplate;
//
//    @GetMapping("/sendMsg/{msg}")
//    public String sendMsg(@PathVariable String msg) {
//
//        ClazzVo clazzVo = new ClazzVo();
//        clazzVo.setClazzNo("1001班");
//        clazzVo.setId("001");
//        rocketMQTemplate.convertAndSend("student", clazzVo);
//
//        return "send success";
//    }
//}
