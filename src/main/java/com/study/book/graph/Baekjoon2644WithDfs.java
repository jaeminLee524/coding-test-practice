package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon2644WithDfs {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int N, M, start, end;
    private static int answer = - 1;

    private static void dfs(int now, int count) {
        visited[now] = true;

        if (now == end) {
            answer = count;
            return;
        }

        for(int next : adjList[now]) {
            if(!visited[next]) {
                dfs(next, count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        visited = new boolean[N + 1];

        int count = 0;
        dfs(start, count);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
