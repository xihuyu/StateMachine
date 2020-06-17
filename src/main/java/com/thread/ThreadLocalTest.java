package com.thread;

/**
 * @version V1.0
 * @description: 测试threadloacal
 * @author: fenggaopan
 * @date: 2020-06-16 17:59:47
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("a");
        Thread t = new Thread(()->{
            System.out.println("线程启动1===========>" + tl.get());
            tl.set("b");
            System.out.println("线程启动2===========>" + tl.get());
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程启动3===========>" + tl.get());
    }
}
