package com.tc51.activemqservice.controller;

import com.tc51.activemq.domain.Client;
import com.tc51.activemq.domain.News;
import com.tc51.activemq.domain.User;
import com.tc51.activemqservice.result.ResultRespone;
import com.tc51.activemqservice.service.PushService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/push")
public class PushController {

    @Resource(name="clientPushService")
    private PushService clientPushService;

    @Resource(name="newsPushService")
    private PushService newsPushService;

    @Resource(name="userPushService")
    private PushService userPushService;

    /**
     * 客户推送
     * @param info
     * @return
     * @author 张炜
     * @create 2020-3-10 下午4:22:28
     */
    @RequestMapping(value="/client",method= RequestMethod.POST)
    @ResponseBody
    public ResultRespone clientPush(Client info){
        ResultRespone respone = new ResultRespone();
        try {
            clientPushService.push(info);
            respone.setData(info);
        } catch (Exception e) {
            e.printStackTrace();
            respone = new ResultRespone(false, e.getMessage());
        }
        return respone;
    }

    /**
     * 新闻推送
     * @param info
     * @return
     * @author 张炜
     * @create 2020-3-10 下午4:22:28
     */
    @RequestMapping(value="/news",method=RequestMethod.POST)
    @ResponseBody
    public ResultRespone newsPush(News info){
        ResultRespone respone = new ResultRespone();
        try {
            newsPushService.push(info);
            respone.setData(info);
        } catch (Exception e) {
            e.printStackTrace();
            respone = new ResultRespone(false, e.getMessage());
        }
        return respone;
    }
    /**
     * 客户推送
     * @param info
     * @return
     * @author zhangwei
     * @create 2020-3-10 下午4:22:28
     */
    @RequestMapping(value="/user",method=RequestMethod.POST)
    @ResponseBody
    public ResultRespone userPush(User info){
        ResultRespone respone = new ResultRespone();
        try {
            userPushService.push(info);
            respone.setData(info);
        } catch (Exception e) {
            e.printStackTrace();
            respone = new ResultRespone(false, e.getMessage());
        }
        return respone;
    }
}
