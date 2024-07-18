package com.study.book.tree;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers77486 {

    private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // 1. 부모 - 자식 맵 생성
        HashMap<String, String> parentMap = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }

        // 2. 누적 수익 맵 생성
        HashMap<String, Integer> moneyMap = new HashMap<>();
        for(int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int sellerMoney = amount[i] * 100;

            while(sellerMoney > 0 && !sellerName.equals("-")) {
                moneyMap.put(sellerName, moneyMap.getOrDefault(sellerName, 0) + sellerMoney - (sellerMoney / 10));
                sellerName = parentMap.get(sellerName);
                sellerMoney /= 10;
            }
        }

        // 3. 판매자 별 수익 결과 반환
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = moneyMap.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] enroll1 = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] enroll2 = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};

        String[] referral1 = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] referral2 = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};

        String[] seller1 = new String[]{"young", "john", "tod", "emily", "mary"};
        String[] seller2 = new String[]{"sam", "emily", "jaimie", "edward"};

        int[] amount1 = new int[]{12, 4, 2, 5, 10};
        int[] amount2 = new int[]{2, 3, 5, 4};

        int[] answer1 = new int[]{360, 958, 108, 0, 450, 18, 180, 1080};
        int[] answer2 = new int[]{0, 110, 378, 180, 270, 450, 0, 0};

        System.out.println(Arrays.equals(answer1, Programmers77486.solution(enroll1, referral1, seller1, amount1)));
        System.out.println(Arrays.equals(answer2, Programmers77486.solution(enroll2, referral2, seller2, amount2)));

    }
}
