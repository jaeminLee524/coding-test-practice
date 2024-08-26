package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon4963 {

    private static int MAX = 50 + 10;
    private static boolean[][] map;
    private static int W, H, answer;
    // 위, 위우 대각선, 우, 우하 대각선,  하, 하좌 대각선,  좌, 좌상 대각선
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    private static void dfs(int y, int x) {
        map[y][x] = false;

        for(int i = 0; i < 8; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(map[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H ==0) {
                break;
            }

            map = new boolean[MAX][MAX];
            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= W; j++)
                    map[i][j] = (Integer.parseInt(st.nextToken()) == 1);
            }

            answer = 0;
            for(int y = 1; y <= H; y++) {
                for(int x = 1; x <= W; x++) {
                    if(map[y][x]) {
                        dfs(y, x);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
