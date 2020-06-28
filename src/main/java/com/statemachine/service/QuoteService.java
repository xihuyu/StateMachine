package com.statemachine.service;

import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @description: 报价服务类
 * @author: fenggaopan
 * @date: 2020-06-23 09:35:19
 */
@Service("quoteService")
public class QuoteService {

    public void createQuote() {
        System.out.println("创建报价单成功..");
    }
}
