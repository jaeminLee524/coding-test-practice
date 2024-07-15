package com.study.book.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers159994 {

    // 시간복잡도 미충족
    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<Integer> wordIndexQueue = new ArrayDeque<>();

        A:
        for (String word : goal) {
            for (int i = 0; i < cards1.length; i++) {
                if (word.equals(cards1[i])) {
                    wordIndexQueue.add(i);
                    continue A;
                }
            }

            for (int j = 0; j < cards2.length; j++) {
                if (word.equals(cards2[j])) {
                    wordIndexQueue.add(j);
                }
            }
        }

        int targetIndex = wordIndexQueue.poll();
        while (!wordIndexQueue.isEmpty()) {
            if (wordIndexQueue.poll() > targetIndex) {
                return "No";
            } else {
                targetIndex = wordIndexQueue.poll();
            }
        }

        return answer;
    }

    private static String solution2(String[] cards1, String[] cards2, String[] goal) {

        String answer = "Yes";
        Queue<String> cards1Queue = new ArrayDeque<>();
        Queue<String> cards2Queue = new ArrayDeque<>();

        for (String card : cards1) {
            cards1Queue.add(card);
        }

        for (String card : cards2) {
            cards2Queue.add(card);
        }

        for (String word : goal) {
            if (word.equals(cards1Queue.peek())) {
                cards1Queue.poll();
                continue;
            } else if (word.equals(cards2Queue.peek())) {
                cards2Queue.poll();
                continue;
            } else {
                return "No";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cards1 = new String[]{"i", "drink", "water"};
        String[] cards2 = new String[]{"want", "to"};
        String[] goal = new String[]{"i", "want", "to", "drink", "water"};
        String result = "Yes";

        System.out.println(Programmers159994.solution2(cards1, cards2, goal).equals(result));
    }
}
