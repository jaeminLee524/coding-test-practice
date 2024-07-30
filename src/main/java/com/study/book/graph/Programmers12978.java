package com.study.book.graph;

import java.util.*;

public class Programmers12978 {

    public static int solution(int N, int[][] road, int K) {

        ArrayList<Node>[] adjList = new ArrayList[N + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트 초기화
        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        // 다익스트라 기록용
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // 우선순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.time));
        queue.add(new Node(1, 0));

        // 방문기록
        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.dest]) {
                continue;
            }

            visited[now.dest] = true;

            for (Node next : adjList[now.dest]) {
                if (now.time + next.time < dist[next.dest]) {
                    dist[next.dest] = now.time + next.time;
                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public static class Node {

        int dest;
        int time;

        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        int N1 = 5;
        int[][] road1 = new int[][]{
            {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
        };
        int K1 = 3;
        int result1 = 4;

        int N2 = 6;
        int[][] road2 = new int[][]{
            {1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}
        };
        int K2 = 4;
        int result2 = 4;

        System.out.println(Programmers12978.solution(N1, road1, K1) == result1);
        System.out.println(Programmers12978.solution(N2, road2, K2) == result2);
    }
}
