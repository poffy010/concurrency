package com.mmall.MainShiTi;

import java.util.Stack;

public class MinStack {
    static Stack<Integer> stack;
    static Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public static void pop() {
        stack.pop();
        minStack.pop();
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stackClazz = new MinStack();
        push(3);
        push(5);
        push(1);
        push(8);
        pop();
        pop();
        System.out.println(getMin());
    }
}
