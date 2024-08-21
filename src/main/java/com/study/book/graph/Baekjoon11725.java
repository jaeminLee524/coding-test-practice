package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon11725 {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] parent;

    private static void dfs(int now) {
        visited[now] = true;

        for (int next : adjList[now]) {
            if (!visited[next]) {
                parent[next] = now;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화 및 할당
        adjList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        // dfs
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1);

        // 출력
        for(int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
