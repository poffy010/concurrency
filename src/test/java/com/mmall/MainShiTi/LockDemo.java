package com.mmall.MainShiTi;

import org.openjdk.jol.info.ClassLayout;

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();

        Thread thread1 = new Thread(()->{
            synchronized (lockDemo){
                System.out.println("t1 抢占到锁");
                System.out.println(ClassLayout.parseInstance(lockDemo).toPrintable());
            }
        });
        thread1.start();
//        Thread.sleep(10000);

        synchronized (lockDemo){
            System.out.println("main 抢占到锁");
            System.out.println(ClassLayout.parseInstance(lockDemo).toPrintable());
        }
    }
}
