package com.data.sort;

import java.util.Arrays;

/**
 * @version V1.0
 * @description: 插入排序
 * @author: fenggaopan
 * @date: 2020-06-17 17:28:35
 */
public class InsertSort {

    public static void main(String[] args) {
        int sortArray[] = new int[]{9,2,3,4,7,0};
        int[] sortedArray = insertSort(sortArray, 6);
        Arrays.stream(sortArray).forEach(value -> {
            System.out.println("排序后的数组未:" + value);
        });
    }

    /**
     * 插入排序方法
     * @param sortArray
     * @param length
     * @return
     */
    public static int[] insertSort(int[] sortArray, int length) {
        for(int i=1; i<length; i++) {
            int j = i-1;
            int value = sortArray[i];
            for(; j>=0 ; j--) {
                if(sortArray[j] > value) {
                    sortArray[j+1] = sortArray[j];
                } else {
                    break;
                }
            }
            sortArray[j+1] = value;
        }
        return sortArray;
    }
}

