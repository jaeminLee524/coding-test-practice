package com.study.book.array;

import java.util.Arrays;

public class Programmers12949 {

    private static int[][] solution(int[][] arr1, int[][] arr2) {

        int r1 = arr1.length;
        int c1 = arr1[0].length;

        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 정답 배열
        int[][] answers = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answers[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answers;
    }

    public static void main(String[] args) {

        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};

        int[][] output1 = new int[][]{{15, 15}, {15, 15}, {15, 15}};

        System.out.println(Arrays.equals(output1, Programmers12949.solution(arr1, arr2)));
    }
}
