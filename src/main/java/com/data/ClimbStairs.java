package com.data;

/**
 * @version V1.0
 * @description: 爬楼梯算法:即一个N阶的楼梯，每次能走1～2阶，问走到N阶一共多少种走法
 * @author: fenggaopan
 * @date: 2020-06-16 16:21:17
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 15;
        long start = System.currentTimeMillis();
        System.out.println(climbStairs2(n));
        long end = System.currentTimeMillis();
        System.out.println("耗时====>" + (end - start));
    }

    /**
     * 爬楼梯，总共n阶，总共多少方法
     * @param n 总阶梯数
     * @return 返回总共的解法
     */
    public static int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 递归方法太耗时，尝试另一种方法
     * 参考:https://blog.crayygy.com/14599905787744.html
     */
    public static int climbStairs2(int n) {
        int[] result = new int[n];
        result[0] = 1;
        if( n>= 2) {
            result[1] = 2;
        }
        for(int i = 2; i < n; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n-1];
    }

}
