package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 16:49
 * @desc
 */
@Slf4j
@NotThreadSafe
public class DateFormatExample1 {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //请求总数
    private static int clientTotal = 5000;
    //并发数
    private static int threadTotal = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i < clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("异常{}",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
//        log.info("size {}",stringBuilder.length());
    }

    private static void update(){
        try {
            sdf.parse("2021-08-10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
