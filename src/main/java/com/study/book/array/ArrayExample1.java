package com.study.book.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class ArrayExample1 {

    // 시간복잡도: O(N)
    private static int[] solution1(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        Arrays.sort(result, Comparator.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    // 시간복잡도 O(NlogN)
    private static int[] solution2(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for (int num : arr) {
            treeSet.add(num);
        }

        int[] result = new int[treeSet.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = treeSet.pollFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{4, 2, 2, 1, 3, 4};
        int[] input2 = new int[]{2, 1, 1, 3, 2, 5, 4};

        int[] output1 = new int[]{4, 3, 2, 1};
        int[] output2 = new int[]{5, 4, 3, 2, 1};

        System.out.println(Arrays.equals(output1, ArrayExample1.solution1(input1)));
        System.out.println(Arrays.equals(output2, ArrayExample1.solution1(input2)));

        System.out.println(Arrays.equals(output1, ArrayExample1.solution2(input1)));
        System.out.println(Arrays.equals(output2, ArrayExample1.solution2(input2)));
    }
}
