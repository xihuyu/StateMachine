package com.statemachine.rocketmq.server;

import com.statemachine.rocketmq.config.MQConstant;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @description: 消息生产者
 * @author: fenggaopan
 * @date: 2020-06-20 15:38:50
 */
@Component
public class MQProducer {

    public static String CONSUMER_GROUP = "order_group";

    private DefaultMQProducer producer;

    public MQProducer(){
        //示例生产者
        producer = new DefaultMQProducer(CONSUMER_GROUP);
        //不开启vip通道 开通口端口会减2
        producer.setVipChannelEnabled(false);
        //绑定name server
        producer.setNamesrvAddr(MQConstant.NAME_SERVER);
        start();
    }

    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getProducer(){
        return this.producer;
    }
    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.producer.shutdown();
    }

}
