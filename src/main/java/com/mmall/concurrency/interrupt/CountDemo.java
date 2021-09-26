package com.mmall.concurrency.interrupt;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Classname CountDemo
 * @Description
 * @Date 2021/9/12 8:43
 * @Created by PoffyZhang
 */
public class CountDemo {
    private static int count = 0;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
//        solution2();
//        char c = '5';
//        int number = 0;
//        number = number * 10 + c - '0';
//        System.out.println(number);
        Map<String,String> map = Maps.newHashMap();
        map.put("1","5");
        System.out.println(map.getOrDefault("1","1"));
    }

    public static void solution2() {
        new Thread(() -> {
            while (count < 100) {
                synchronized (LOCK) {
                    if ((count & 1) == 0) {
                        System.out.println("偶数线程 -> " + count++);
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (LOCK) {
                    if ((count & 1) == 1) {
                        System.out.println("奇数线程 -> " + count++);
                    }
                }
            }
        }).start();
    }
}
