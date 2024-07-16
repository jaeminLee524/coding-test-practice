package com.study.book.hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers131127 {

    private static int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();

        // 구매 희망 map
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 0번 인덱스부터 10개씩
        for(int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for(int j = i; j < 10 + i; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if(wantMap.equals(discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want1 = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = new int[]{3, 2, 2, 2, 1};
        String[] discount1 = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int result1 = 3;

        String[] want2 = new String[]{"apple"};
        int[] number2 = new int[]{10};
        String[] discount2 = new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int result2 = 0;

        System.out.println(Programmers131127.solution(want1, number1, discount1) == result1);
        System.out.println(Programmers131127.solution(want2, number2, discount2) == result2);
    }
}
