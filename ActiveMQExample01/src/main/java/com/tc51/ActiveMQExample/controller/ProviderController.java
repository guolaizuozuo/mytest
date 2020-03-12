package com.tc51.ActiveMQExample.controller;

import com.tc51.ActiveMQExample.pojo.Student;
import com.tc51.ActiveMQExample.produce.QueueProducer;
import com.tc51.ActiveMQExample.produce.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProviderController {
    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private TopicProducer topicProducer;
    //注入存放消息的队列，用于下列方法一

    @GetMapping("/value")
    public String value() {
        String queueName="QUEUE_RECEIVE_ADD_FIREND"; //自定义队列名称
        Student student = new Student();
        student.setName("小明"+ UUID.randomUUID().toString());
        student.setAge(11);
        queueProducer.sendObjectMessage(queueName, student);   //发送到MQS
        return "消息已经发送";
    }

    @GetMapping("/topicvalue")
    public String topicvalue() {
        String queueName="TOPIC_RECEIVE_ADD_FIREND"; //自定义队列名称
        Student student = new Student();
        student.setName("小明"+ UUID.randomUUID().toString());
        student.setAge(11);
        topicProducer.sendObjectMessage(queueName, student);   //发送到MQS
        return "TOPIC消息已经发送";
    }

}