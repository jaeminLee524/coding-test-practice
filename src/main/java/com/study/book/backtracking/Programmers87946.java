package com.study.book.backtracking;

import java.util.Arrays;

public class Programmers87946 {

    private static int[][] Dungeons;
    private static boolean[] visited;
    private static int answer;

    private static int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        answer = 0;

        backtracking(k, 0);

        return answer;
    }

    private static void backtracking(int k, int cnt) {
        for(int i = 0; i < Dungeons.length; i++) {
            if(!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;

                backtracking(k - Dungeons[i][1], cnt + 1);

                answer = Math.max(answer, cnt + 1);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeouns = new int[][]{
            {80, 20},
            {50, 40},
            {30, 10}
        };
        int result = 3;

        System.out.println(Programmers87946.solution(k, dungeouns) == result);
    }
}
