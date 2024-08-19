package com.study.book.graph;

import java.io.*;
import java.util.*;

public class Baekjoon11724 {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer M = Integer.parseInt(st.nextToken());
        Integer N = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화, 할당
        adjList = new ArrayList[M + 1];
        for(int i = 0; i < M + 1; i++) {
            adjList[i] = new ArrayList<>();
        }


        int  x, y;
        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st2.nextToken());
            y = Integer.parseInt(st2.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        // 방문 배열 초기화
        visited = new boolean[M + 1];

        for(int i = 1; i < M + 1; i++ ){
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;

        for(int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
