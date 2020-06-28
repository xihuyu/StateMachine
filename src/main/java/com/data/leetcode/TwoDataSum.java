package com.data.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @description: 返回两数之和等于指定值的下标
 * @author: fenggaopan
 * @date: 2020-06-17 20:30:17
 */
public class TwoDataSum {

    public static void main(String[] args) {
        int nums[] = new int[]{3,3};
        int target = 6;
        int [] result = twoDataSum(nums, target);
        Arrays.stream(result).forEach(elem ->{
            System.out.println("下标为" + elem);
        });
    }

    /**
     * 查找下标
     * @param data 数组
     * @param target 目标和
     * @return
     */
    public static int[] twoDataSum(int [] data, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i=0; i<data.length; i++) {
            if(!sumMap.containsKey(data[i])) {
                sumMap.put(data[i], i);
            }

        }

        int flag = 0;
        int p = 0;
        //遍历map
        for(int i=0;i<data.length;i++) {
            if(sumMap.containsKey(target - data[i])) {
                flag = i;
                p = sumMap.get(target - data[i]);
            }
        }
        return new int[]{flag, p};
    }

}
