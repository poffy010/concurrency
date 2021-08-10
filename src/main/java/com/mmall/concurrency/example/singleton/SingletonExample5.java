package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 懒汉模式 双重同步锁 double check
 */
@ThreadSafe
public class SingletonExample5 {

    //构造私有函数
    private SingletonExample5(){

    }

    // 单例对象 防止指令重排序
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    public static SingletonExample5 getInstance(){
        if(instance == null){//双重监测机制
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }

        return instance;
    }
}
