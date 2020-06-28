package com.statemachine.controller;

import com.statemachine.rocketmq.config.MQConstant;
import com.statemachine.rocketmq.server.MQProducer;
import com.statemachine.service.QuoteService;
import com.statemachine.util.AppUtil;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @description: 订单询报价API
 * @author: fenggaopan
 * @date: 2020-06-20 15:42:18
 */
@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private MQProducer mqProducer;

    @RequestMapping("/quote-order")
    public String quoteOrder() {
        String quoteMsg = "订单报价";
        try {
            Message message = new Message(MQConstant.TOPIC, "quote_tag", quoteMsg.getBytes());
            mqProducer.getProducer().send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("发送MQ消息成功");
        return "报价成功!";
    }


    @RequestMapping("/getBeans")
    public String getBeans() {
        QuoteService quoteService = (QuoteService) AppUtil.getBean("quoteService");
        quoteService.createQuote();
        return "SUCCESS";
    }

    @RequestMapping("/goDance/")
    public String goDance() {
        System.out.println("跳转到报价单页面");
        return "page/go";
    }
}
