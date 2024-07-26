package com.study.book.graph;

import java.util.ArrayDeque;

public class Programmers1844 {

    // 상 하 좌 우
    private static int[] nx = {0, 0, -1, 1};
    private static int[] ny = {1, -1, 0, 0};

    private static class Node {
        int row;
        int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        int[][] dist = new int[N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for( int i = 0; i < 4; i++) {
                int newRow = now.row + nx[i];
                int newColumn = now.column + ny[i];

                // 이탈
                if (newRow < 0 || newColumn < 0 || newRow >= N || newColumn >= M) {
                    continue;
                }

                // 벽
                if(maps[newRow][newColumn] == 0) {
                    continue;
                }

                // 처음 방문한 길의 경우
                if(dist[newRow][newColumn] == 0) {
                    queue.addLast(new Node(newRow, newColumn));
                    dist[newRow][newRow] = dist[now.row][now.column] + 1;
                }
            }
        }

        return dist[N -1][M -1] == 0 ? -1 : dist[N -1][M -1];
    }

    public static void main(String[] args) {
        int[][] maps1 = new int[][]{
            {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
        };
        int result1 = 11;

        int[][] maps2 = new int[][]{
            {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}
        };
        int result2 = -1;

        System.out.println(Programmers1844.solution(maps1) == result1);
        System.out.println(Programmers1844.solution(maps2) == result2);
    }
}
