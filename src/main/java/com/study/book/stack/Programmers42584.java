package com.study.book.stack;

import java.util.Arrays;
import java.util.Stack;

public class Programmers42584 {

    private static int[] solution(int[] prices) {

        int[] result = new int[prices.length];

        int idxLen = prices.length - 1;

        A:
        for (int i = 0; i <= idxLen; i++) {
            if (i == idxLen) {
                result[i] = 0;
                break;
            }

            int answer = 0;
            for (int j = i + 1; j <= idxLen; j++) {
                if (prices[i] > prices[j]) {
                    result[i] = j - i;
                    continue A;
                } else {
                    answer++;
                }
            }

            result[i] = answer;
        }

        return result;
    }

    private static int[] solution2(int[] prices) {

        int len = prices.length;

        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                result[i]++;

                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return result;
    }

    private static int[] solution3(int[] prices) {
        int dataLen = prices.length;
        int[] result = new int[dataLen];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < dataLen; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                Integer idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = dataLen - 1 - idx;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] input = new int[]{1, 2, 3, 2, 3};
        int[] output = new int[]{4, 3, 1, 1, 0};

        System.out.println(Arrays.equals(Programmers42584.solution(input), output));
        System.out.println(Arrays.equals(Programmers42584.solution2(input), output));
        System.out.println(Arrays.equals(Programmers42584.solution3(input), output));
    }
}
