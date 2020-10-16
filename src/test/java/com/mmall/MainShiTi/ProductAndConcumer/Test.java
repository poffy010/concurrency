package com.mmall.MainShiTi.ProductAndConcumer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Queue<String> msg = new LinkedList<>();
        int maxSize = 5;

        Product product = new Product(msg,maxSize);
        Concumer concumer = new Concumer(msg,maxSize);

        Thread thread1 = new Thread(product);
        Thread thread2 = new Thread(concumer);

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
