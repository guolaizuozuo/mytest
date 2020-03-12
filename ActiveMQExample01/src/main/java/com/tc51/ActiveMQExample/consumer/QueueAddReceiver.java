package com.tc51.ActiveMQExample.consumer;

import com.tc51.ActiveMQExample.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 创建消息的监听类（消费者）
 */
@Component
public class QueueAddReceiver {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @JmsListener(destination = "QUEUE_RECEIVE_ADD_FIREND", containerFactory = "MyjmsQueueListener")
    public void receiveAddFriend(Student student) {
        System.out.println("Receiver:"+student.toString());
        logger.info("receiveAddFriend Exception:{}");
    }

}
