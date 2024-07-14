package com.study.book.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers42889 {

    private static int[] solution(int N, int[] stages) {

        HashMap<Integer, Double> failsMap = new HashMap<>();

        // 스테이지 별 도달 현황 전체 순회
        for (int i = 1; i < N + 1; i++) {
            int notComp = 0;
            int alreadyComp = 0;
            for (int j = 0; j < stages.length; j++) {

                // 현재 스테이지(i)와 같은 스테이지의 경우 분자
                if (i == stages[j]) {
                    notComp += 1;
                }

                // 현재 스테이지(i)보다 같거나 큰 경우 분모
                if (stages[j] >= i) {
                    alreadyComp += 1;
                }
            }

            // notComp || alredayComp = 0 -> 0
            if (notComp == 0 || alreadyComp == 0) {
                failsMap.put(i, 0.0);
            } else {
                failsMap.put(i, Double.valueOf(notComp) / Double.valueOf(alreadyComp));
            }
        }

        return failsMap.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }

    private static int[] solution2(int N, int[] stages) {

        // stages = [2, 1, 2, 6, 2, 4, 3, 3]

        // 스테이지 도전자 배열 생성
        int[] challenger = new int[N + 2];

        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        // 실패율 맵 생성
        HashMap<Integer, Double> failMap = new HashMap<>();
        double totalChallenger = stages.length;

        // 스테이지 별 실패율 계산
        for (int i = 1; i <= N; i++) {
            // 해당 스테이지의 참여자가 없으면, 실패율 0
            if (challenger[i] == 0) {
                failMap.put(i, 0.0);
            } else {
                failMap.put(i, challenger[i] / totalChallenger);
            }

            // 총 도전자 수 - 현재 스테이지 도전자 수
            totalChallenger -= challenger[i];
        }

        return failMap.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }


    public static void main(String[] args) {

        int N1 = 5;
        int[] stages1 = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int[] result1 = new int[]{3, 4, 2, 1, 5};

        int N2 = 4;
        int[] stages2 = new int[]{4, 4, 4, 4, 4};
        int[] result2 = new int[]{4, 1, 2, 3};

        System.out.println(Arrays.equals(result1, Programmers42889.solution2(N1, stages1)));
        System.out.println(Arrays.equals(result2, Programmers42889.solution2(N2, stages2)));
    }
}
