package com.tc51.activemqservice.service.impl;


import com.tc51.activemq.domain.News;
import com.tc51.activemqservice.activeMQ.QueueProducer;
import com.tc51.activemqservice.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service("newsPushService")
public class NewsPushServiceImpl implements PushService {


	@Autowired
	private QueueProducer queueProducer;

	@Value("${activeQueueNewsName}")
	private String  queueName;

	@Override
	public void push(final Object info) {
		News p = (News) info;
		queueProducer.sendObjectMessage(queueName, info);   //发送到MQS


	}

}
