package com.study.book.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ArrayList;

public class BreadthFirstExample {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer = new ArrayList<>();

    private static int[] solution(int [][] graph, int start, int n) {

        adjList = new ArrayList[n + 1];
        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 초기화
        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];

        bfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            // 큐에서 꺼냄
            Integer now = queue.pollFirst();
            // 기록
            answer.add(now);

            for (int next : adjList[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
            {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}
        };

        int start = 1;
        int n = 9;
        int[] result =new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.equals(BreadthFirstExample.solution(graph, start, n), result));
    }
}
