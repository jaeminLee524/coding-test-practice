package com.study.book.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Programmers92334 {

    private static int[]  solution(String[] id_list, String[] report, int k) {

        // 반환 배열
        int[] result = new int[id_list.length];

        // 신고 내역 map
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
        }

        // 신고 횟수 맵
        HashMap<String, Integer> reportCountMap = new HashMap<>();
        //report 순회하면서 id별 신고 내역를 HashMap에 저장
        for(String s: report) {
            String[] splitData = s.split(" ");

            // 신고 내역을 가져와 추가
            HashSet<String> reportedSet = reportMap.get(splitData[0]);
            if(!reportedSet.contains(splitData[1])) {
                // 신고 내역에 추가
                reportedSet.add(splitData[1]);

                // 신고당한 사람의 카운트 증가, 중복 체크
                reportCountMap.put(splitData[1], reportCountMap.getOrDefault(splitData[1], 0) +1);
            }
        }

        // k번 이상 신고된 id 리스트
        ArrayList<String> reportTarget = new ArrayList<>();
        for(Entry<String, Integer> entry : reportCountMap.entrySet()) {
            if(entry.getValue() >= k) {
                reportTarget.add(entry.getKey());
            }
        }

        // 신고내역에서 reportTarget에 해당하는 애가 있으면
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> reported = reportMap.get(id_list[i]);
            for(int j = 0; j < reportTarget.size(); j++) {
                if(reported.contains(reportTarget.get(j))) {
                    result[i] +=1;
                }
            }
        }

        return result;
    }

    private static int[]  solution2(String[] id_list, String[] report, int k) {
        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String, Integer> count = new HashMap<>();

        for(String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if(!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }

            reportedUser.get(reportedId).add(userId);
        }

        for (Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if(entry.getValue().size() >= k) {
                for(String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            };
        }

        int[] answer = new int[id_list.length];

        for(int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

    private static int[]  solution3(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();

        for(String r : report) {
            String[] s = r.split(" ");
            String reportUserId = s[0];
            String reportedUserId = s[1];

            // 초기화
            if (!reportedUser.containsKey(reportedUserId)) {
                reportedUser.put(reportedUserId, new HashSet<>());
            }

            reportedUser.get(reportedUserId).add(reportUserId);
        }

        // 신고한 유저에게 카운트 증가
        for(Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for(String reportUid : entry.getValue()) {
                    reportCount.put(reportUid, reportCount.getOrDefault(reportUid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i]  = reportCount.getOrDefault(id_list[i], 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list1 = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report1 = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k1 = 2;
        int[] result1 = new int[]{2, 1, 1, 0};

        String[] id_list2 = new String[]{"con", "ryan"};
        String[] report2 = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;
        int[] result2 = new int[]{0, 0};

        System.out.println(Arrays.equals(Programmers92334.solution(id_list1, report1, k1), result1));
        System.out.println(Arrays.equals(Programmers92334.solution(id_list2, report2, k2), result2));
        System.out.println(Arrays.equals(Programmers92334.solution2(id_list1, report1, k1), result1));
        System.out.println(Arrays.equals(Programmers92334.solution2(id_list2, report2, k2), result2));
        System.out.println(Arrays.equals(Programmers92334.solution3(id_list1, report1, k1), result1));
        System.out.println(Arrays.equals(Programmers92334.solution3(id_list2, report2, k2), result2));
    }
}
