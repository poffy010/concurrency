package com.mmall.MainShiTi;

public class VolatileDemo {
    private static boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            int i = 0;
//            System.out.println("i:" + i);
            while (!stop){
                i++;
            }
        });
        thread.start();
        Thread.sleep(10);
        stop = true;

    }
}
