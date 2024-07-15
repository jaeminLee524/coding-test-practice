package com.study.book.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Programmers42576 {

    private static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        // 동명이인 때문에 참여자 별 몇명인지 map에 저장
        for(String part: participant) {
            map.put(part, (map.getOrDefault(part, 0)) + 1);
        }

        // 완주자를 탐색하면서 참여자 인원 -1
        for(String comp: completion) {
            map.put(comp, map.get(comp) - 1);
        }

        String answer = "";
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant1 = new String[]{"leo", "kiki", "eden"};
        String[] completion1 = new String[]{"eden", "kiki"};
        String result1 = "leo";

        String[] participant2 = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = new String[]{"josipa", "filipa", "marina", "nikola"};
        String result2 = "vinko";

        String[] participant3 = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = new String[]{"stanko", "ana", "mislav"};
        String result3 = "mislav";

        System.out.println(Programmers42576.solution(participant1, completion1).equals(result1));
        System.out.println(Programmers42576.solution(participant2, completion2).equals(result2));
        System.out.println(Programmers42576.solution(participant3, completion3).equals(result3));
    }
}
