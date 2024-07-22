package com.study.book.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Programmers1845 {

    private static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(nums.length / 2, set.size());
    }

    private static int solution2(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        return Math.min(nums.length / 2, set.size());
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 1, 2, 3};
        int result1 = 2;

        int[] nums2 = new int[]{3, 3, 3, 2, 2, 4};
        int result2 = 3;

        int[] nums3 = new int[]{3, 3, 3, 2, 2, 2};
        int result3 = 2;

        System.out.println(Programmers1845.solution(nums1) == result1);
        System.out.println(Programmers1845.solution(nums2) == result2);
        System.out.println(Programmers1845.solution(nums3) == result3);

        System.out.println(Programmers1845.solution2(nums1) == result1);
        System.out.println(Programmers1845.solution2(nums2) == result2);
        System.out.println(Programmers1845.solution2(nums3) == result3);
    }
}
