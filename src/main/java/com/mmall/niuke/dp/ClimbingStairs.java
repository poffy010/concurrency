package com.mmall.niuke.dp;

/**
 * @author Poffy Zhang
 * @date 2021/8/18 16:21
 * @desc 爬楼梯
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbingstairs(6));
    }

    public int climbingstairs(int n){
        if(n <= 3){
            return n;
        }

        int[] result = new int[n + 1];

        result[1] = 1;
        result[2] = 2;

        for(int i = 3; i <= n;i++){
            result[i] = result[i - 2] + result[i - 1];
        }

        return result[n];
    }
}
