package com.data.queue;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * @version V1.0
 * @description: 环形队列
 * @author: fenggaopan
 * @date: 2020-06-30 14:28:39
 */
public class CircleQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入元素");
        boolean loop = true;
        while(scanner.hasNext()) {
            System.out.println("输入的值为:" + scanner.next());
            loop = false;
            break;
        }
    }
}
