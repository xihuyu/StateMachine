package com.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @description: 信号量
 * @author: fenggaopan
 * @date: 2020-07-01 14:31:28
 */
public class SemphoreDemo {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Tech(s, "" + i));
            t.start();
        }
    }

}

class Tech implements Runnable {

    private String name;

    private Semaphore semaphore;

    public Tech(Semaphore semaphore, String  name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("技师" + name + "单子被接!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
