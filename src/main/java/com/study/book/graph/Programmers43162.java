package com.study.book.graph;

public class Programmers43162 {

    private static boolean[] visited;
    private static int[][] computer;

    private static void bfs(int now) {
        visited[now] = true;
        for(int i =0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                bfs(i);
            }
        }
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = new int[][]{
            {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
        int result1 = 2;

        int n2 = 3;
        int[][] computers2 = new int[][]{
            {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        };
        int result2 = 1;

        System.out.println(Programmers43162.solution(n1, computers1) == result1);
        System.out.println(Programmers43162.solution(n2, computers2) == result2);
    }
}
