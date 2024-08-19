package com.study.book.graph;

import java.io.*;
import java.util.*;

public class Baekjoon24480 {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] answer;
    private static int visitOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 할당
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y);
            adjList[y].add(x);
        }

        // 인접 리스트 값 역순으로 정렬
        for(ArrayList<Integer> list : adjList) {
            Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        }

        // 방문 기록 배열 초기화
        visited = new boolean[N + 1];

        // 정답 기록 배열 초기화
        answer = new int[N + 1];

        // 방문 순서 초기화
        visitOrder = 1;

        // 탐색 시작
        dfs(R);

        // 정답 출력
        for(int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer[now] = visitOrder++;

        for(int next : adjList[now]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
