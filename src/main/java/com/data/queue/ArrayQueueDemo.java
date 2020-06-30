package com.data.queue;

/**
 * @version V1.0
 * @description: 数组队列
 * @author: fenggaopan
 * @date: 2020-06-29 19:45:06
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}

class ArrayQueue {
    //最大容量
    private int maxSize;
    //队列头
    private int head;
    //队列尾
    private int rear;
    //存放队列数据
    private int[] arr;

    //队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = -1;
        head = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize -1 ;
    }

    //判断是否为空
    public boolean isEmpty() {
        return head == rear;
    }

    /**
     * 元素入队
     * @param data
     */
    public void addQueue(int data) {
        if(isFull()) {
            System.out.println("队列满了,不允许添加................");
            return ;
        }

        rear ++; //让rear后移
        arr[rear] = data;
    }

    public int getQueue() throws Exception  {
        if(isEmpty()) {
            System.out.println("队列是空的,不允许出队............");
            throw new Exception("队列是空的，不允许出队..........");
        }
        return arr[head];
    }


}
