package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 饿汉模式
 */
@ThreadSafe
public class SingletonExample6 {

    //构造私有函数
    private SingletonExample6(){

    }

    // 单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }



    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }
}
