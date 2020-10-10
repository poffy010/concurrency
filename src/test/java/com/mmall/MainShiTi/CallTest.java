package com.mmall.MainShiTi;

import java.util.concurrent.*;

public class CallTest extends Thread implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true){
            TimeUnit.SECONDS.sleep(1000);
        }
//        return "SUCCESS";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallTest callTest = new CallTest();
//        Future<String> future = executorService.submit(callTest);
//        System.out.println(future.get());

        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"poffyThread").start();
    }
}
