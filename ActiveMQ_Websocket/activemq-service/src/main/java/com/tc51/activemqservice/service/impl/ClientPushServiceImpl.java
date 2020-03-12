package com.tc51.activemqservice.service.impl;


import com.tc51.activemq.domain.Client;
import com.tc51.activemqservice.activeMQ.QueueProducer;
import com.tc51.activemqservice.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("clientPushService")
public class ClientPushServiceImpl implements PushService {

	@Autowired
	private QueueProducer queueProducer;

	@Value("${activeQueueClientName}")
	private String  queueName;

	@Override
	public void push(final Object info) {
		Client p = (Client) info;
		queueProducer.sendObjectMessage(queueName, info);   //发送到MQS


	}

}
