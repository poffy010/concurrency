package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Poffy Zhang
 * @date 2021/8/9 10:54
 * @desc
 */
@Slf4j
@NotThreadSafe
public class Escape {

    private int thisCanbeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{

        public InnerClass (){
            log.info("{}",Escape.this.thisCanbeEscape);
        }
    }

    public static void main(String[] args) {
        Escape escape = new Escape();
    }
}
