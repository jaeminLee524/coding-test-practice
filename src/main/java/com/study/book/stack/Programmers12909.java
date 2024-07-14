package com.study.book.stack;

import java.util.Stack;

public class Programmers12909 {

    private static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        char[] array = s.toCharArray();

        for(int i = 0; i < array.length; i++) {
            char item = array[i];

            if(item == '(') {
                stack.push(item);
            } else {
                if (stack.isEmpty() || stack.pop() == item) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {

        String input1 = "()()";
        boolean answer1 = true;

        String input2 = "(())()";
        boolean answer2 = true;

        String input3 = ")()(";
        boolean answer3 = false;

        String input4 = "(()(";
        boolean answer4 = false;

        String input5 = "()()(";

        System.out.println(Programmers12909.solution(input1));
        System.out.println(Programmers12909.solution(input2));
        System.out.println(Programmers12909.solution(input3));
        System.out.println(Programmers12909.solution(input4));
        System.out.println(Programmers12909.solution(input5));
    }
}
