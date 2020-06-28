package com.statemachine.config;

import com.statemachine.interceptor.IpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @version V1.0
 * @description: webmvcconfig
 * @author: fenggaopan
 * @date: 2020-06-23 10:04:10
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    public static String path[] = {"/quote/getBeans"};

    @Bean
    public IpInterceptor ipInterceptor() {
        return new IpInterceptor();
    }

    //这个方法可以添加很多个interceptor，我们可以在interceptor里对要执行的controller方法，
    //在此之前进行校验参数，或者调用一些其他系统的feign接口进行判断是否继续执行改cotroller
    //返回false，表示不允许执行，true表示继续执行
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipInterceptor()).addPathPatterns(path);
    }

    //配置多个路由规则
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("quote/goDance").setViewName("page/go");
    }
}
