package com.study.book.stack;

import java.util.Stack;

public class Programmers12973 {

    private static int solution(String s) {

        Stack<Character> stack = new Stack<>();

        char[] array = s.toCharArray();

        for(char c : array) {
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    private static int solution2(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char data = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().equals(data)) {
                stack.pop();
            } else {
                stack.push(data);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {

        String input1 = "baabaa";
        int output1 = 1;

        String input2 = "cdcd";
        int output2 = 0;

        System.out.println(Programmers12973.solution2(input1) == output1);
        System.out.println(Programmers12973.solution2(input2) == output2);
    }
}
