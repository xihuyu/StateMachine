package com.statemachine.constant;

/**
 * @version V1.0
 * @description: 状态信息
 * @author: fenggaopan
 * @date: 2020-06-15 09:30:37
 */
public enum State {
    UNPAID,   //未支付
    WAITING_FOR_RECEIVE, //等待收货
    DONE   //结束
}
