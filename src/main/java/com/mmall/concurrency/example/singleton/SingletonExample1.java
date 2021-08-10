package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 懒汉模式
 */
@NotThreadSafe
public class SingletonExample1 {

    //构造私有函数
    private SingletonExample1(){

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }

        return instance;
    }
}
