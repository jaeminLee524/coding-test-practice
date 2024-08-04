package com.study.book.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for(int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> nums = new ArrayList<>(selectedNums);
                nums.add(i);
                backtrack(sum + i, nums, i +1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        backtrack(0, new ArrayList<>(), 1);

        return result;
    }

    public static void main(String[] args) {
        int n1 = 5;
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<>(List.of(
            new ArrayList<>(List.of(1, 2, 3, 4)),
            new ArrayList<>(List.of(1, 4, 5)),
            new ArrayList<>(List.of(2, 3, 5))
        ));

        int n2 = 2;
        ArrayList<ArrayList<Integer>> result2 = new ArrayList<>();

        int n3 = 7;
        ArrayList<ArrayList<Integer>> result3 = new ArrayList<>(List.of(
            new ArrayList<>(List.of(1, 2, 3, 4)),
            new ArrayList<>(List.of(1, 2, 7)),
            new ArrayList<>(List.of(1, 3, 6)),
            new ArrayList<>(List.of(1, 4, 5)),
            new ArrayList<>(List.of(2, 3, 5)),
            new ArrayList<>(List.of(3, 7)),
            new ArrayList<>(List.of(4, 6))
        ));

        System.out.println(Example1.solution(n1).equals(result1));
        System.out.println(Example1.solution(n2).equals(result2));
        System.out.println(Example1.solution(n3).equals(result3));
    }
}
