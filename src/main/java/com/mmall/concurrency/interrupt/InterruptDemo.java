package com.mmall.concurrency.interrupt;

/**
 * @Classname InterruptDemo
 * @Description
 * @Date 2021/9/11 8:54
 * @Created by PoffyZhang
 */
public class InterruptDemo implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptDemo());
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

    @Override
    public void run() {
//        while (true){
            try{
                Thread.sleep(100000000);
            }catch (InterruptedException e){
                System.out.println("被复位!!");
                e.printStackTrace();
//                Thread.currentThread().interrupt();
            }
//        }
    }
}
