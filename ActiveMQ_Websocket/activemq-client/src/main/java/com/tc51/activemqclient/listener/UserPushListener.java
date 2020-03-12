package com.tc51.activemqclient.listener;

import com.alibaba.fastjson.JSON;
import com.tc51.activemq.domain.User;
import com.tc51.activemqclient.controller.websocket.WebsocketController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component("userPushListener")
public class UserPushListener {
	 protected static final Logger logger = LoggerFactory.getLogger(UserPushListener.class);


	@JmsListener(destination = "user.service.queue", containerFactory = "MyjmsQueueListener")
	public void receiveAddClient(User client) {


		System.out.println("==============================接受到的客户信息 开始====================================");
		System.out.println(client.toString());

		String jsonStr=JSON.toJSONString(client);
		System.out.println(jsonStr);
		System.out.println("==============================接受到的客户信息 结束====================================");
		WebsocketController.broadcast("user", jsonStr);

	}

}

