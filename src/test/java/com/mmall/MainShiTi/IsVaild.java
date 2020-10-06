package com.mmall.MainShiTi;

import java.util.Stack;

public class IsVaild {
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }

            if(c == ')'){
                System.out.println("stack.peek(): ) " + stack.peek());
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }

            if(c == ']'){
                System.out.println("stack.peek(): ] " + stack.peek());
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }

            if(c == '}'){
                System.out.println("stack.peek(): } " + stack.peek());
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{([(1,2)])}";
        boolean isValid = isValid(s);
        System.out.println(isValid);


    }
}
