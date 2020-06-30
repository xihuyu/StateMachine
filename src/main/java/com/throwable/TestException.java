package com.throwable;

import sun.misc.Cleaner;

/**
 * @version V1.0
 * @description: 测试exception和error
 * @author: fenggaopan
 * @date: 2020-06-30 09:30:48
 */
public class TestException {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.classnotfoundexcetion 找不到类的时候抛出
        //Class c = Class.forName("com.xxx");
        //2.NoClassDefFoundError
        //编译的时候有这个类，启动的加载的时候没有这个类，打包的时候可能漏了或者被篡改了
        int  a = 3;
        System.out.printf("%d", a);
    }
}
