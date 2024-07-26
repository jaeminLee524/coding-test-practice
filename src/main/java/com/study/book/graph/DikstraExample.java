package com.study.book.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DikstraExample {

    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static int[] solution(int[][] graph, int start, int n) {
        ArrayList<Node>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        // 저장공간 초기화
        int[] dist = new int[n];
        // 모든 노드의 거리 값을 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 노드의 거리 값 초기화
        dist[start] = 0;

        // 우선순위 큐를 생성하여 시작노드 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            // 목적지의 최소 비용 < 현재 노드 가중 -> 방문 처리
            if(dist[now.dest] < now.cost) {
                continue;
            }

            for(Node next : adjList[now.dest]) {
                if(now.cost + next.cost < dist[next.dest]) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, now.cost + next.cost));
                }
            }
        }

        return dist;
    }

    private static int[] solution2(int[][] graph, int start, int n) {
        ArrayList<Node>[] adjList = new ArrayList[n];
        for(int i = 0; i< adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.dest]) {
                continue;
            }

            visited[now.dest] = true;

            for(Node next : adjList[now.dest]) {
                if (now.cost + next.cost < dist[next.dest]) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
            {0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}
        };
        int start= 0;
        int n = 3;
        int[] result = new int[]{0, 4, 3};


        System.out.println(Arrays.equals(DikstraExample.solution(graph, start, n), result));
        System.out.println(Arrays.equals(DikstraExample.solution2(graph, start, n), result));
    }
}
