package com.mmall.niuke.huawei;

import java.util.Scanner;

/**
 * @author Poffy Zhang
 * @date 2021/9/3 17:31
 * @desc
 */
public class LeetCode0903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int high = sc.nextInt();

            if(high < 1){
                System.out.println(0);
                return;
            }

            if(high == 1){
                System.out.println(1);
                return;
            }

            int sum = 1;
            for(int i = 1;i < high;i++){
                sum = (sum * 2) - i + (i + 1) * 2;
            }

            System.out.println(sum);
        }
    }
}
