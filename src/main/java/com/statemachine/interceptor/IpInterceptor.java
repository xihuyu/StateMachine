package com.statemachine.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @description: ip地址过滤
 * @author: fenggaopan
 * @date: 2020-06-23 10:11:34
 */
public class IpInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        System.out.println("===================>" + url);
        return !url.contains("localhost");
    }
}
