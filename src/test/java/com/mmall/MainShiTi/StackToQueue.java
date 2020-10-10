package com.mmall.MainShiTi;

import java.util.Stack;

public class StackToQueue {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {
        push(1000000);
        push(2);
        push(3);
        push(4);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    public static void push(int pushNum){
        stack1.push(pushNum);
    }

    public static int pop(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return stack2.pop();
    }
}
