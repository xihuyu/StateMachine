package com.data.sort;

import java.util.Arrays;

/**
 * @version V1.0
 * @description: 冒泡排序
 * 思路:是第一个元素和相邻元素进行比较，如果大于则交换，然后继续交换，直到一次循环遍历后，最大的元素已经到了数组末尾，需要遍历n*n次
 * @author: fenggaopan
 * @date: 2020-06-17 15:08:05
 */
public class BubbleSort {

    public static void main(String[] args) {
        int bubbleArray[] = new int[]{4,8,7,5,2,6};
        int length = 6;
        int sortedArray[] = bubbleSort(bubbleArray, length);
        Arrays.stream(sortedArray).forEach(value -> {
            System.out.println("排序后的元素为:" + value);
        });
    }

    /**
     * 冒泡排序
     * @param bubbleArray 待排序数组
     * @param length 数组长度
     * @return 返回排序后的数组
     */
    public static int[] bubbleSort(int bubbleArray[], int length) {
        for(int i=0; i< length; i++) {
            //遍历元素
            for(int j=0;j<length-1; j++) {
                if(bubbleArray[j] > bubbleArray[j+1]) {
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j+1];
                    bubbleArray[j+1] = temp;
                }
            }
        }
        return bubbleArray;
    }
}
