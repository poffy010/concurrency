package com.mmall.concurrency.interrupt;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicDemo
 * @Description
 * @Date 2021/9/11 11:21
 * @Created by PoffyZhang
 */
public class AtomicDemo {
    private AtomicInteger i = new AtomicInteger();

//    int i;
    public static void main(String[] args) throws InterruptedException {
        AtomicDemo atomicDemo = new AtomicDemo();
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[2];
        for(int i = 0;i < 2;i++){
            threads[i] = new Thread(()->{
                for(int k = 0;k < 1000000;k++){
                    atomicDemo.incr();
                }
            });
            threads[i].start();
        }
        threads[0].join();
        threads[1].join();
        long end = System.currentTimeMillis();
        System.out.println("Result:" + atomicDemo.i.get() + " time:" + (end-start) + "ms");
//        System.out.println("Result:" + atomicDemo.i + " time:" + (end-start) + "ms");
    }

    private synchronized void incr() {
        i.addAndGet(1);
//        i++;
    }
}
