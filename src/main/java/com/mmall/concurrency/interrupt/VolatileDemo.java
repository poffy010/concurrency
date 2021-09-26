package com.mmall.concurrency.interrupt;

/**
 * @Classname VolatileDemo
 * @Description
 * @Date 2021/9/11 14:03
 * @Created by PoffyZhang
 */
public class VolatileDemo {
    private volatile static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            int i = 0;
           while(!flag){
               i++;
            }
        });
        t1.start();
        System.out.println("Start thread!");
        Thread.sleep(1000);
        flag = true;
    }
}
