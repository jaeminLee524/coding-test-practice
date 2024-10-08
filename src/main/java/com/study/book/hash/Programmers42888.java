package com.study.book.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers42888 {

    private static String[] solution(String[] record) {

        // id:닉네임 을 담을 Map 생성
        Map<String, String> map = new HashMap<>();
        for(String chat: record) {
            String[] chatSplit = chat.split(" ");

            // 0인덱스 값이 "L"로 시작하지 않으면 배열에 넣기
            if(!chatSplit[0].startsWith("L")) {
                // 1인덱스 값인 id, 2인덱스 값인 닉네임 넣기
                map.put(chatSplit[1], chatSplit[2]);
            }
        }

        // 2. record 배열을 다시 순회하면서 result 생성
        ArrayList<String> result = new ArrayList<>();
        for(String chat: record) {
            String[] chatSplit = chat.split(" ");
            String status =  chatSplit[0];
            String id = chatSplit[1];

            // Enter
            if(status.startsWith("E")) {
                String nickNameById = map.get(id);
                result.add(nickNameById + "님이 들어왔습니다.");
            }

            // Leave
            if(status.startsWith("L")) {
                String nickNameById = map.get(id);
                result.add(nickNameById + "님이 나갔습니다.");
            }
        }

        return result.stream().toArray(String[]::new);
    }

    private static String[] solution2(String[] record) {
        // Enter, Leave 메시지 저장 Map
        Map<String, String> msg  = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        Map<String, String> idMap = new HashMap<>();
        for(String chat: record) {
            String[] cmd = chat.split(" ");
            if(cmd.length == 3) {
                idMap.put(cmd[1], cmd[2]);
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        for(String chat: record) {
            String[] cmd = chat.split(" ");

            if(msg.containsKey(cmd[0])) {
                answer.add(idMap.get(cmd[1]) + msg.get(cmd[0]));
            }
        }

        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] record = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};

        System.out.println(Arrays.equals(Programmers42888.solution(record), result));
        System.out.println(Arrays.equals(Programmers42888.solution2(record), result));
    }
}
