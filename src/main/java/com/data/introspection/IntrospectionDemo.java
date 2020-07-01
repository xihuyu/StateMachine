package com.data.introspection;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * @version V1.0
 * @description: JAVA内省
 * jdk提供了内省机制，也就是Introspector来操作bean,getBeans可以获得bean的所有信息
 * @author: fenggaopan
 * @date: 2020-07-01 10:15:36
 */
public class IntrospectionDemo {

    public static void main(String[] args) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        System.out.println("所有的属性为:");
        //获得所有属性的描述
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        Arrays.stream(descriptors).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor.getName());
        });
    }
}
