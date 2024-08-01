package com.study.book.graph;

import java.util.ArrayList;

public class Programmers86971 {

    private static  boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int N;
    private static int answer;

    private static int solution(int n, int[][] wires) {
        N = n;
        answer = n -1;

        adjList = new ArrayList[n + 1];
        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        visited = new boolean[n + 1];

        dfs(1);

        return answer;
    }

    // 자식 노드를 탐색할때마다 최소 송전 탑 개수를 구하는 방식
    private static int dfs(int now) {
        visited[now] = true;

        int sum = 0;
        for(int next : adjList[now]) {
            if(!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                sum+=cnt;
            }
        }

        int returnValue = sum + 1;
        System.out.println("now = " + now + " nodeCnt = " + returnValue);

        return sum + 1;
    }

    // 자식 노드를 모두 구한 후 최소 값을 구하는 방식
    private static int dfs2(int now) {
        visited[now] = true;

        int child = 1;
        for(int next : adjList[now]) {
            if (!visited[next]) {
                child += dfs(next);
            }
        }

        answer = Math.min(answer, Math.abs(N - 2 * child));

        return child;
    }

    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = new int[][]{
            {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };
        int result1 = 3;

        int n2 = 4;
        int[][] wires2 = new int[][]{
            {1,2},{2,3},{3,4}
        };
        int result2 = 0;

        int n3 = 7;
        int[][] wires3 = new int[][]{
            {1,2},{2,7},{3,7},{3,4},{4,5},{6,7}
        };
        int result3 = 1;


        System.out.println(Programmers86971.solution(n1, wires1) == result1);
//        System.out.println(Programmers86971.solution(n2, wires2) == result2);
//        System.out.println(Programmers86971.solution(n3, wires3) == result3);
    }
}
