package com.mmall.concurrency.example.aqs;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Poffy Zhang
 * @date 2021/8/13 9:39
 * @desc
 */
@Slf4j
@ThreadSafe
public class CountDownLatchExample1 {

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{

        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 0;i < threadCount;i++){
            final int threadNum = i;
            exec.execute(()->{
                try{
                    test(threadNum);
                }catch (Exception e){
                    log.error("{}",e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}",threadNum);
        Thread.sleep(100);
    }
}
