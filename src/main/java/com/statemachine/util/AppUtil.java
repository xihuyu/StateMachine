package com.statemachine.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @description: 工具类
 * @author: fenggaopan
 * @date: 2020-06-23 09:29:54
 */
@Service
public class AppUtil implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取bean
     */
    public static Object getBean(String param) {
        return applicationContext.getBean(param);
    }
}
