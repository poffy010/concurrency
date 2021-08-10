package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 饿汉模式
 */
@ThreadSafe
public class SingletonExample2 {

    //构造私有函数
    private SingletonExample2(){

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
