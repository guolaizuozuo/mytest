package com.tc51.activemqservice.service;

/**
 * 推送的接口
 * @author Administrator
 * @create 2020-3-10 下午3:41:03
 * @version 1.0
 */
public interface PushService {

	//public final ExecutorService pushExecutor = Executors.newFixedThreadPool(10);
	
	public void push(Object info);
	
}
