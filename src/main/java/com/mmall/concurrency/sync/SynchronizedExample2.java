package com.mmall.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Poffy Zhang
 * @date 2021/8/9 10:11
 * @desc
 */
@Slf4j
public class SynchronizedExample2 {

    //修饰一个类
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for(int i=0;i<10;i++){
                log.info("test1:{}-{}",j,i);
            }
        }
    }

    //修饰一个静态方法
    public static synchronized void test2(int j){
        for(int i=0;i<10;i++){
            log.info("test2:{}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronizedExample1.test1(1);
        });

        executorService.execute(()->{
            synchronizedExample2.test1(2);
        });
    }
}
