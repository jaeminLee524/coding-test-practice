package com.study.book.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Programmers42840 {

    // 1차원 배열
    private static int[] solution(int[] answers) {

        int[] supo1 = new int[]{1, 2, 3, 4, 5};
        int[] supo2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        HashMap<Integer, Integer> map = new HashMap<>();

        // 수포자 별 각각 answers를 돌면서 몇 문제를 맞췄는지 체크
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supo1[i % supo1.length]) {
                Integer supo1Score = map.getOrDefault(1, 0);
                supo1Score += 1;
                map.put(1, supo1Score);
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supo2[i % supo2.length]) {
                Integer supo2Score = map.getOrDefault(2, 0);
                supo2Score += 1;
                map.put(2, supo2Score);
            }
        }

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supo3[i % supo3.length]) {
                Integer supo3Score = map.getOrDefault(3, 0);
                supo3Score += 1;
                map.put(3, supo3Score);
            }
        }

        Integer maxValue = map.values().stream()
            .max(Comparator.comparing(Integer::intValue))
            .get();

        ArrayList<Integer> list = new ArrayList<>();

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= maxValue) {
                list.add(entry.getKey());
            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    // 2차원 배열 활용
    private static int[] solution2(int[] answers) {

        int[][] pattern = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int score[] = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    score[j] += 1;
                }
            }
        }

        int maxScore = Arrays.stream(score).max().getAsInt();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (maxScore == score[i]) {
                result.add(i + 1);
            }
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int[] answers1 = new int[]{1, 2, 3, 4, 5};
        int[] answers2 = new int[]{1, 3, 2, 4, 2};
        int[] answers3 = new int[]{4, 3, 5, 5, 2, 1};

        int[] return1 = new int[]{1};
        int[] return2 = new int[]{1, 2, 3};
        int[] return3 = new int[]{3};

        System.out.println(Arrays.equals(return1, Programmers42840.solution(answers1)));
        System.out.println(Arrays.equals(return2, Programmers42840.solution(answers2)));
        System.out.println(Arrays.equals(return3, Programmers42840.solution(answers3)));

        System.out.println(Arrays.equals(return1, Programmers42840.solution2(answers1)));
        System.out.println(Arrays.equals(return2, Programmers42840.solution2(answers2)));
        System.out.println(Arrays.equals(return3, Programmers42840.solution2(answers3)));
    }
}
