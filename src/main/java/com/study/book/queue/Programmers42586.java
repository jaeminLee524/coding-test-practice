package com.study.book.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Programmers42586 {

    private static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> result = new ArrayDeque<>();
        int n = progresses.length;

        // 남은 양의 데이터를 보관할 작업 큐 생성
        int[] leftTasks = new int[n];
        for(int i = 0; i < n; i++) {
            leftTasks[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int targetTask = leftTasks[0];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(targetTask >= leftTasks[i]) {
                answer++;
            } else {
                result.add(answer);
                answer = 1;
                targetTask = leftTasks[i];
            }
        }

        result.add(answer);

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        int[] result1 = new int[]{2, 1};

        int[] progresses2 = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[]{1, 1, 1, 1, 1, 1};
        int[] result2 = new int[]{1, 3, 2};

        System.out.println(Arrays.equals(result1, Programmers42586.solution(progresses, speeds)));
        System.out.println(Arrays.equals(result2, Programmers42586.solution(progresses2, speeds2)));
    }
}
