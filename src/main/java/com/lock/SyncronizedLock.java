package com.lock;

/**
 * @version V1.0
 * @description: synchronized锁
 * @author: fenggaopan
 * @date: 2020-06-24 10:01:24
 */
public class SyncronizedLock {

    int sum = 0;

    public synchronized void addNum(int a, int b) {
        sum = a + b;
    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("xxx");
        }).start();

        String test = "http://10.240.5.224:8080/default/7397d781-2375-4724-a6b5-620d788e84ac?type=image,http://10.240.5.224:8080/default/f24d3d52-f16e-47a0-b2d3-205a6f2f7eea?type=image,http://10.240.5.224:8080/default/3c8fa562-2e58-43b0-8428-d96e0462e21e?type=image,http://10.240.5.224:8080/default/1ceed181-8c2b-418a-a26b-67849893324a?type=image,http://10.240.5.224:8080/default/7f7bb61a-43fe-4ffa-9a6b-c05572a4d7c7?type=image,http://10.240.5.224:8080/default/480d21ba-9332-4eaf-b8a9-7c5ad9c0df34?type=image,http://10.240.5.224:8080/default/add1637c-d462-4f48-975c-8e327f4cb59a?type=image,http://10.240.5.224:8080/default/d37e2da9-4f1b-4169-97d1-3ed8aa6311ca?type=image,http://10.240.5.224:8080/default/d4e2595b-be9a-4ae7-9dad-794940109176?type=image";
        System.out.println(test.length());
    }
}
