package com.study.book.hash;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Example1 {

    // 시간 초과가 발생할 수 있음
    private static boolean solution(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int sqrt = (int) Math.sqrt(target);

        // target을 생성할 수 있는 약수의 짝을 구하기
        for(int i = 1; i <= sqrt; i++) {
            if (target % i ==0) {
                int value = target - i;
                map.put(i, value);
                map.put(value, i);
            }
        }

        // 짝이 없으면 false
        if (map.isEmpty()) {
            return false;
        }

        // arr 배열 순회
        // map의 key가 arr에 있고 key에 해당하는 value도 arr에 있는지 체크
        for(Integer key: map.keySet()) {
            for (int element : arr) {
                if (element == key) {
                    Integer value = map.get(key);
                    for(int valueElement : arr) {
                        if (value == valueElement) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    // 저자 풀이법
    private static boolean solution2(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for(int element: arr) {
            if (set.contains(target - element)) {
                return true;
            }

            set.add(element);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 8};
        int target1 = 6;
        boolean return1 = true;

        int[] arr2 = new int[]{2, 3, 5, 9};
        int target2 = 10;
        boolean return2 = false;

        System.out.println(return1 == Example1.solution2(arr1, target1));
        System.out.println(return2 == Example1.solution2(arr2, target2));
    }
}
