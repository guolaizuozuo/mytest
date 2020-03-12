package com.tc51.activemqclient.listener;

import com.alibaba.fastjson.JSON;
import com.tc51.activemq.domain.News;
import com.tc51.activemqclient.controller.websocket.WebsocketController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component("newsPushListener")
public class NewsPushListener {
	 protected static final Logger logger = LoggerFactory.getLogger(NewsPushListener.class);


	@JmsListener(destination = "news.service.queue", containerFactory = "MyjmsQueueListener")
	public void receiveAddClient(News client) {


		System.out.println("==============================接受到的客户信息 开始====================================");
		System.out.println(client.toString());

		String jsonStr=JSON.toJSONString(client);
		System.out.println(jsonStr);
		System.out.println("==============================接受到的客户信息 结束====================================");
		WebsocketController.broadcast("news", jsonStr);

	}

}

