package com.mmall.MainShiTi;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class InterruptedDemo {
    private Object lock = new Object();
    public InterruptedDemo (Object lock){
        this.lock = lock;
    }

    public void demo(){
        synchronized (lock){
            while (true){
                System.out.println("哈哈");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new InterruptedDemo());
//        thread.start();
//        thread.sleep(2000);
//        thread.interrupt();
        Object object = new Object();
        InterruptedDemo interruptedDemo1 = new InterruptedDemo(object);
        InterruptedDemo interruptedDemo2 = new InterruptedDemo(object);

        new Thread(()->{
            interruptedDemo1.demo();
        },"Poffy-01").start();

        new Thread(()->{
            interruptedDemo2.demo();
        },"Poffy-02").start();
    }
}
