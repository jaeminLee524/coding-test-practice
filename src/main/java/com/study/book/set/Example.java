package com.study.book.set;

import java.util.ArrayList;
import java.util.Arrays;

public class Example {

    private static int[] elements;

    private static Boolean[] solution(int k, int[][] operations) {
        // 원소 초기화
        createElements(k);

        ArrayList<Boolean> result = new ArrayList<>();
        for (int[] operation : operations) {
            // 합치기
            if (operation[0] == 0) {
                union(operation[1], operation[2]);
            } else {
                result.add(find(operation[1]) == find(operation[2]));
            }
        }

        Boolean[] array = result.toArray(Boolean[]::new);
        System.out.println("array = " + Arrays.toString(array));

        return array;
    }

    private static int find(int data) {
        if (elements[data] == data) {
            return data;
        }

        elements[data] = find(elements[data]);
        return  elements[data];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        elements[root1] = root2;
    }

    private static void createElements(int k) {
        elements = new int[k];
        for (int i = 0; i < k; i++) {
            elements[i] = i;
        }
    }

    public static void main(String[] args) {
        int k1 = 3;
        int[][] operations1 = new int[][]{{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        Boolean[] result1 = new Boolean[]{true};

        int k2 = 4;
        int[][] operations2 = new int[][]{{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
        Boolean[] result2 = new Boolean[]{false, true};

        System.out.println(Arrays.equals(Example.solution(k1, operations1), result1));
        System.out.println(Arrays.equals(Example.solution(k2, operations2), result2));
    }
}
