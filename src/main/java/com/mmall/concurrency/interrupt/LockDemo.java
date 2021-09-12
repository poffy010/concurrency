package com.mmall.concurrency.interrupt;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LockDemo
 * @Description
 * @Date 2021/9/11 20:51
 * @Created by PoffyZhang
 */
public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();
    }
}
