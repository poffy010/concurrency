package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 懒汉模式 性能开销 不推荐
 */
@ThreadSafe
public class SingletonExample3 {

    //构造私有函数
    private SingletonExample3(){

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    public synchronized static SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }

        return instance;
    }
}
