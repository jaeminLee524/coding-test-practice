package com.study.book.graph;

import java.util.*;
import java.io.*;

public class Baekjoon2644WithBfs {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] distinct;

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        distinct[start] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : adjList[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distinct[next] = distinct[now] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aPerson = Integer.parseInt(st.nextToken()); // 첫 번째 사람
        int bPerson = Integer.parseInt(st.nextToken()); // 두 번째 사람

        int M = Integer.parseInt(br.readLine()); // 관계의 수

        // 인접리스트 초기화 및 할당
        adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        // 방문 배열 초기화
        visited = new boolean[N + 1];
        // 거리(촌수) 배열 초기화
        distinct = new int[N + 1];

        // BFS로 촌수 계산
        bfs(aPerson);

        // 두 사람 간의 촌수 출력
        if (distinct[bPerson] == 0 && aPerson != bPerson) { // 연결되지 않은 경우
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(distinct[bPerson]));
        }

        br.close();
        bw.close();
    }
}
