package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

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
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector <>();

    public static void main(String[] args) throws Exception{

        while (true){
            for(int i = 0;i < 10;i++){
                vector.add(i);
            }

            Thread t1 = new Thread(){
                @Override
                public void run(){
                    for(int i = 0;i < vector.size();i++){
                        vector.remove(i);
                    }
                }
            };

            Thread t2 = new Thread(){
                @Override
                public void run(){
                    for(int i = 0;i < vector.size();i++){
                        vector.get(i);
                    }
                }
            };

            t1.start();
            t2.start();
        }
    }
}
