package com.tc51.activemqclient.controller;

import com.tc51.activemqclient.result.ResultRespone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class IndexController {

	@RequestMapping(value="/index",method=RequestMethod.POST)
	@ResponseBody
	public ResultRespone index(){
		ResultRespone respone = new ResultRespone();
		respone.setData("欢迎来到我的界面");
		return respone;
	}

	@RequestMapping("/")
	public String toLogin() {
		return "index.html";
	}

	
}
