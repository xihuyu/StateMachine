package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * @version V1.0
 * @description: 定位死锁的类列表
 * @author: fenggaopan
 * @date: 2020-07-01 14:15:41
 */
public class DeadLockTools {
    public static void main(String[] args) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        Runnable task = ()->{
            long [] threadIds = mxBean.findDeadlockedThreads();
            if(threadIds != null) {
                ThreadInfo[] ts = mxBean.getThreadInfo(threadIds);
                Arrays.stream(ts).forEach(threadInfo -> {
                    System.out.println("线程的信息为:" + threadInfo.getThreadName());
                });
            }
        };

        task.run();
    }
}
