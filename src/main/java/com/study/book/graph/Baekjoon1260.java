package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon1260 {


    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> dfsAnswer;
    private static ArrayList<Integer> bfsAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 인접리스트 초기화
        adjList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트 할당
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        // 오름차순 정렬
        for (ArrayList<Integer> list : adjList) {
            Collections.sort(list);
        }

        // 방문 배열 초기화
        visited = new boolean[N + 1];

        // 정답 배열 초기화
        dfsAnswer = new ArrayList<>();
        bfsAnswer = new ArrayList<>();

        dfs(V);

        visited = new boolean[N + 1];


        bfs(V);

        for (int i = 0; i < dfsAnswer.size(); i++) {
            bw.write(dfsAnswer.get(i) + (i == dfsAnswer.size() ? "" : " "));
        }

        bw.newLine();

        for (int i = 0; i < bfsAnswer.size(); i++) {
            bw.write(bfsAnswer.get(i) + (i == bfsAnswer.size() ? "" : " "));
        }

        br.close();
        bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;
        dfsAnswer.add(now);

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            bfsAnswer.add(now);

            for(int next : adjList[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
