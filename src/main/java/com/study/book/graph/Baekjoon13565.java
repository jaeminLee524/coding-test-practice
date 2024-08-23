package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon13565 {
    private static boolean[][] map;
    private static int M;
    private static int N;
    // 상 우 하 좌
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static boolean answer;

    private static void dfs(int y, int x) {
        if (y == M - 1) {
            answer = true;
            return;
        }
        // 1-1. 벽으로 변경
        map[y][x] = false;

        // 1-2. 상하좌우 탐색
        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            // 2-1. 벽 체크
            if(newY < 0 || newX < 0 || newY >= M || newX >= N || !map[newY][newX]) {
                continue;
            }

            dfs(newY, newX);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) == '0';
            }
        }

        for(int x = 0; x < N; x++) {
            if(map[0][x]) {
                dfs(0, x);
            }

            if (answer) {
                break;
            }
        }

        if (answer) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }
}
