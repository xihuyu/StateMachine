package com.statemachine.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @version V1.0
 * @description: 事件配置
 * @author: fenggaopan
 * @date: 2020-06-15 10:52:14
 */
@WithStateMachine
public class EventConfigure {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @OnTransition(target = "UNPAID")
    public void create() {
        logger.info("=========>订单创建,待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        logger.info("=========>订单已支付,待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        logger.info("=========>已确认收货,订单结束");
    }


}
