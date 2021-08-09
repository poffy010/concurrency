package com.demo.park;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Poffy Zhang
 * @date 2021/7/12 10:11
 * @desc
 */
public class ParkDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           while (true){
               System.out.println("子线程执行~~");
           }
        });
        t1.start();
        LockSupport.park();
        Thread.sleep(8000);
        LockSupport.unpark(t1);
    }
}
