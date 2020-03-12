package com.tc51.activemqservice.service.impl;

import com.tc51.activemq.domain.User;
import com.tc51.activemqservice.activeMQ.QueueProducer;
import com.tc51.activemqservice.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service("userPushService")
public class UserPushServiceImpl implements PushService {
	/**
	 * 这里是根据MQ配置文件定义的queue来注入的，也就是这里将会把不同的内容推送到不同的queue中
	 */

	@Autowired
	private QueueProducer queueProducer;

	@Value("${activeQueueUserName}")
	private String  queueName;

	@Override
	public void push(final Object info) {
		User p = (User) info;
		queueProducer.sendObjectMessage(queueName, info);   //发送到MQS


	}

}
