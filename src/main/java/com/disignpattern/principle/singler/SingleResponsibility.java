package com.disignpattern.principle.singler;

/**
 * @version V1.0
 * @description: 单一职责
 * @author: fenggaopan
 * @date: 2020-06-27 14:10:33
 */
public class SingleResponsibility {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        //飞机和汽车都能跑，违背了单一职责原则
        vehicle.run("飞机");
        vehicle.run("汽车");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "交通工具路上跑");
    }
}

