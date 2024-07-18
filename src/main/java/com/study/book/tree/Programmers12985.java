package com.study.book.tree;

public class Programmers12985 {

    private static int solution(int n, int a, int b) {

        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        int result = 3;

        System.out.println(result == Programmers12985.solution(n, a, b));
    }
}
