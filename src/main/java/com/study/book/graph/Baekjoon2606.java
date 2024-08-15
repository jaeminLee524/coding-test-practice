package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon2606 {

    private static boolean[] visited;
    private static boolean[][] graph;
    private static int M, N;
    private static int answer;

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            visited = new boolean[N + 1];
            graph = new boolean[N + 1][N +1];

            int x, y;
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                graph[x][y] = true;
                graph[y][x] = true;
            }

            dfs(1);

            bw.write(String.valueOf(answer - 1));

            br.close();
            bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer++;

        for(int i = 1; i <= N; i++) {
            if (!visited[i] && graph[now][i]) {
                dfs(i);
            }
        }
    }
}
