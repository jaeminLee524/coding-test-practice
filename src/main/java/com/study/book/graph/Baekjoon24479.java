package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon24479 {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] answer;
    private static int visitOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        for (ArrayList<Integer> list : adjList) {
            Collections.sort(list);
        }

        visited = new boolean[N + 1];
        answer = new int[N + 1];
        visitOrder = 1;

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer[now] = visitOrder;
        visitOrder++;

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
