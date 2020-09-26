package com.mmall.concurrency.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
public class AtomicExample5 {
    private static AtomicIntegerFieldUpdater<AtomicExample5> update =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5  atomicExample5 = new AtomicExample5();
        if(update.compareAndSet(atomicExample5,100,120)){
            log.info("update success:{}",atomicExample5.getCount());
        }

        if(update.compareAndSet(atomicExample5,100,120)){
            log.info("update success:{}",atomicExample5.getCount());
        }else{
            log.info("update fail:{}",atomicExample5.getCount());
        }
    }
}
