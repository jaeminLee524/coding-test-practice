package com.study.book.array;

import java.util.Arrays;
import java.util.HashSet;

public class Programmers68644 {

    private static int[] solution(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();

        // 1. 모든 경우의 수 찾기
        for(int i = 0; i < numbers.length -1; i++) {
            for(int j = i +1; j < numbers.length; j++) {
                // 2. 중복 제거
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 3. 오름차순 정렬
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int[] input1 = new int[]{2, 1, 3, 4, 1};
        int[] input2 = new int[]{5, 0, 2, 7};

        int[] output1 = new int[]{2, 3, 4, 5, 6, 7};
        int[] output2 = new int[]{2, 5, 7, 9, 12};

        System.out.println(Arrays.equals(output1, Programmers68644.solution(input1)));
        System.out.println(Arrays.equals(output2, Programmers68644.solution(input2)));
    }
}
