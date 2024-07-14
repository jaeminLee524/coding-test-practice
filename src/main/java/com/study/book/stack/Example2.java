package com.study.book.stack;

import java.util.Stack;

public class Example2 {

    private static String solution(int decimal) {

        Stack<Integer> stack = new Stack<>();

        while(decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int decimal1 = 10;
        String answer1 = "1010";

        int decimal2 = 27;
        String answer2 = "11011";

        int decimal3 = 12345;
        String answer3 = "11000000111001";

        System.out.println(Example2.solution(decimal1).equals(answer1));
        System.out.println(Example2.solution(decimal2).equals(answer2));
        System.out.println(Example2.solution(decimal3).equals(answer3));
    }
}
