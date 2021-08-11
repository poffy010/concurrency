package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
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
@ThreadSafe
public class VectorExample1 {

    //请求总数
    private static int clientTotal = 5000;
    //并发数
    private static int threadTotal = 200;

    private static Vector<Integer> vector = new Vector <>();

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i < clientTotal;i++){
            int finalI = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update(finalI);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("异常{}",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size {}",vector.size());
    }

    private static void update(int i){
        vector.add(i);
    }
}
