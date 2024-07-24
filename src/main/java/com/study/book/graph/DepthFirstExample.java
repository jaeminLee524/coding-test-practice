package com.study.book.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DepthFirstExample {

    // 인접리스트
    private static ArrayList<Integer>[] adjList;
    // 방문기록
    private static boolean[] visited;
    // 답
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        // 인접리스트 초기화
        adjList = new ArrayList[n + 1];
        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트 생성
        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // 방문기록 초기화
        visited = new boolean[n + 1];

        answer = new ArrayList<>();

        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);

        for(int start : adjList[now]) {
            if (!visited[start]) {
                dfs(start);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = new int[][]{
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 5}
        };

        int start1 = 1;

        int n = 5;

        int[] result1 = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.equals(DepthFirstExample.solution(graph1, start1, n), result1));
    }
}
