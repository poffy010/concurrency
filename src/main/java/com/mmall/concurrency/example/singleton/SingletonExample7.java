package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.Recommend;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 9:36
 * @desc 枚举模式 最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //构造私有函数
    private SingletonExample7(){

    }

    //静态的工厂方法
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM 保证这个方法 只被调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
