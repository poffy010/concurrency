package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author Poffy Zhang
 * @date 2021/8/10 16:49
 * @desc
 */
@Slf4j
@ThreadSafe
public class VectorExample3 {

    //会抛异常 ConcurrentModificationException
    private static void test1(Vector<Integer> v1){
        for(Integer i : v1){
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //会抛异常 ConcurrentModificationException
    private static void test2(Vector<Integer> v1){
        Iterator<Integer> iterable = v1.iterator();
        while (iterable.hasNext()){
            Integer i = iterable.next();
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //正常
    private static void test3(Vector<Integer> v1){
        for(int i = 0;i < v1.size();i++){
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) throws Exception{

        Vector<Integer> vector = new Vector <>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
