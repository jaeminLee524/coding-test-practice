package com.study.book.queue;

import java.util.ArrayDeque;

public class Example1 {

    private static int solution(int N, int K) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i < N + 1; i++) {
            deque.add(i);
        }

        // k개씩 pollFirst();
        // LastPoll();
        // 언제까지? => 요소가 하나 남을때까지
        while(deque.size() > 1) {
            for(int i = 0; i < K; i++) {
                deque.addLast(deque.pollFirst());
            }

            deque.pollLast();
        }

        return deque.poll();
    }

    public static void main(String[] args) {


        int N = 5;
        int K = 2;
        int result = 3;

        System.out.println(Example1.solution(N,K) == result);
    }
}
