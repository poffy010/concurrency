package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 懒汉模式 双重同步锁 double check
 */
@NotThreadSafe
public class SingletonExample4 {

    //构造私有函数
    private SingletonExample4(){

    }

    // 单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static SingletonExample4 getInstance(){
        if(instance == null){//双重监测机制
            synchronized (SingletonExample4.class){
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }
        }

        return instance;
    }
}
