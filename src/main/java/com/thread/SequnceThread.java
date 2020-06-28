package com.thread;

import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @description: 线程根据指定的顺序执行
 * @author: fenggaopan
 * @date: 2020-06-24 11:07:44
 */
public class SequnceThread {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }

    /**
     * 2使用single线程池顺序执行线程
     */
    private static void sequenceThread2() {
        Thread t1 = new Thread(()->{
            System.out.println("线程1");
        });

        Thread t2 = new Thread(()->{
            System.out.println("线程2");
        });


        Thread t3= new Thread(()->{
            System.out.println("线程3");
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);

        executor.shutdown();
    }

    /**
     * 2.使用jion顺序执行
     * @throws Exception
     */
    public static void sequenceThread1() throws Exception {
        Thread t1 = new Thread(()->{
            System.out.println("线程1");
        });

        Thread t2 = new Thread(()->{
            System.out.println("线程2");
        });


        Thread t3= new Thread(()->{
            System.out.println("线程3");
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}
