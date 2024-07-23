package com.study.book.set;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers42861 {

    private static int[] parent;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int edges = 0;

        // 비용을 오름차순으로 정렬
//        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // parent 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : costs) {
            if(edges == n - 1) {
                break;
            }

            // 순환형성이 안된경우
            if(find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }

        return answer;
    }

    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        parent[root2] = root1;
    }

    public static void main(String[] args) {
        System.out.println(Programmers42861.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}) == 4);
    }
}
