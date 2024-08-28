package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon1388 {
    private static int MAX = 50 + 10;
    private static char[][] map;
    private static boolean[][] visited;
    private static int N, M, answer;

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        // '-' 인 경우 x + 1
        // '|' 인 경우 y + 1
        if(map[y][x] == '-' && map[y][x + 1] == '-') {
            dfs(y, x + 1);
        } else if(map[y][x] == '|' && map[y + 1][x] == '|'){
            dfs(y + 1, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];
        for(int y = 1; y <= N; y++) {
            String str = br.readLine();
            for(int x = 1; x <= M; x++) {
                map[y][x] = str.charAt(x - 1);
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
