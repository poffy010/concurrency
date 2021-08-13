package com.mmall.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Poffy Zhang
 * @date 2021/8/13 15:12
 * @desc
 */
@Slf4j
public class LockExample5 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
           try{
               lock.lock();
               log.info("await condition~");
               condition.await();
           }catch (InterruptedException e){
               log.error("{}",e);
           }finally {
               log.info("get signal");
               lock.unlock();
           }
        }).start();

        new Thread(()->{
            lock.lock();
            log.info("get lock");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                log.error("{}",e);
            }
            condition.signalAll();
            log.info("send signal~~");
            lock.unlock();
        }).start();
    }
}
