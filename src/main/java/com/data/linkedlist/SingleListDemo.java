package com.data.linkedlist;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Selector;

/**
 * @version V1.0
 * @description: 单链表
 * @author: fenggaopan
 * @date: 2020-06-30 14:56:04
 */
public class SingleListDemo {

    public static void main(String[] args) {

    }
}

class SingleList {
    //初始化一个头节点
    private HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 添加一个节点
     * @param node 待添加的节点
     */
    public void addNode(HeroNode node) {
        HeroNode temp = headNode;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出循环的时候temp指向最后的元素
        temp.next = node;
    }

    /**
     * 删除节点
     * @param node 待删除的节点
     * @return 返回结果
     */
    public boolean deleteNode(HeroNode node) {
        HeroNode temp = headNode;
        HeroNode deleteNode = headNode;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
            if(temp.next == node) {
                //要删除元素的前一个元素
                deleteNode = temp;
                deleteNode.next = temp.next.next;
            }
        }
        return true;
    }

}


class HeroNode {
    int no;
    String name;
    String nickname;
    HeroNode next;  //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
