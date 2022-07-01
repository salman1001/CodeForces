package com.company.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        String s = sc.next();
        Stack<Character> stack = new Stack<>();
        boolean isvalid = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ')') {
                if (stack.isEmpty()) {
                    isvalid = false;

                } else {
                    if (stack.pop() != '(') {
                        isvalid = false;

                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty()) isvalid = false;
                    else {
                        if (stack.pop() != '[') isvalid = false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty()) isvalid = false;
                    else {
                        if (stack.pop() != '{') isvalid = false;
                    }
                }

            }
            System.out.println(isvalid && stack.empty());


        }
    }
}
