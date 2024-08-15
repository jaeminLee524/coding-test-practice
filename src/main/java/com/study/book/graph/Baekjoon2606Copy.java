package com.study.book.graph;

import java.util.ArrayList;

public class Baekjoon2606Copy {

    private static boolean[][] graph;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static ArrayList<Integer> answer;

    private static int solution(int[][] graph, int n, int computer) {
        adjList = new ArrayList[n + 1];
        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];

        answer = new ArrayList<>();
        bfs(computer);

        return answer.size() - 1;
    }

    private static void bfs(int now) {
        visited[now] = true;
        answer.add(now);

        for (int start : adjList[now]) {
            if (!visited[start]) {
                bfs(start);
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph = new int[][]{
            {1, 2}, {2, 3}, {1, 5}, {5, 2}, {5, 6}, {4, 7}
        };
        int result = 4;
        int n = 7;
        int computer = 1;

        System.out.println(solution(graph, n, computer) == result);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //


    }
}
