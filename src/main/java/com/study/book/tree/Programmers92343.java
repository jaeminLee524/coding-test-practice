package com.study.book.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class Programmers92343 {

    private static ArrayList<Integer>[] tree;

    private static int solution(int[] info, int[][] edges) {
        // 트리 생성
        buildTree(info, edges);
        // 최대 양의 수 지정
        int answer = 0;

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        // BFS(넓이 우선 탐색) 시작
        while (!queue.isEmpty()) {
            // 큐에서 현재 상태 꺼냄
            Info now = queue.poll();
            // 최대 양의 수 업데이트
            answer = Math.max(answer, now.sheep);
            // 방문한 노드 집합에 현재 노드의 이웃 노드 추가
            now.visited.addAll(tree[now.node]);

            // 인접 노드들에 대해 탐색
            for (int next : now.visited) {
                // 기존 해시셋의 데이터를 복사 후 현재 방문한 정점을 해시셋에서 제거
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if (info[next] == 1) {
                    if (now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }

        return answer;
    }

    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    // 트리 정보 생성
    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public static void main(String[] args) {

        int[] info = new int[]{0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = new int[][]{{0,1}, {1, 2}, {1,4}, {0,8}, {8,7}, {9,10}, {9,11}, {4,3}, {6,5}, {4,6}, {8,9}};
        int answer = 5;

        System.out.println(Programmers92343.solution(info, edges) == answer);
    }
}
