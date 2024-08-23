package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon1012 {

    private static final int MAX = 50 + 10;
    private static int[][] map;
    // 상 우 하 좌
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    private static void dfs(int y, int x) {
        map[y][x] = 0;

        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(map[newY][newX] == 1) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[MAX][MAX];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y + 1][x + 1] = 1;
            }

            int answer = 0;
            for(int y = 1; y <= N; y++) {
                for(int x = 1; x <= M; x++) {
                    if(map[y][x] == 1) {
                        answer++;
                        dfs(y, x);
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
