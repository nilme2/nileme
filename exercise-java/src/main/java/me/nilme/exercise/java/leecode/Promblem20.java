package me.nilme.exercise.java.leecode;

import java.util.Stack;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem20 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.empty() && (stack.peek() + 1 == c || stack.peek() + 2 == c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        Promblem20 promblem = new Promblem20();
        System.out.println(promblem.isValid("([)]"));
        System.out.println(promblem.isValid("(){}"));
        System.out.println(promblem.isValid("{[]}"));

    }
}

