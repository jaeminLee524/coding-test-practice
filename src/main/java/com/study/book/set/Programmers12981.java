package com.study.book.set;

import java.util.Arrays;
import java.util.HashSet;

public class Programmers12981 {

    private static int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];

        for(int i = 0; i < words.length; i++) {
            String word = words[i];

            answer[0] = (i % n) + 1;
            answer[1] = (i / n) + 1;

            // 단어 체크
            if(i != 0) {
                String prev = words[i-1];
                char prevWord = prev.toCharArray()[prev.length() - 1];
                char currWord = word.toCharArray()[0];

                if(prevWord != currWord) {
                    return answer;
                }
            }

            // 한단어 체크
            if(word.length() == 1) {
                return answer;
            }

            // 중복 체크
            if(set.contains(word)) {
                return answer;
            }
        }

        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 5;
        int n3 = 2;

        String[] words1 = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};

        int[] result1 = new int[]{3, 3};
        int[] result2 = new int[]{0, 0};
        int[] result3 = new int[]{1, 3};

        System.out.println(Arrays.equals(Programmers12981.solution(n1, words1), result1));
        System.out.println(Arrays.equals(Programmers12981.solution(n2, words2), result2));
        System.out.println(Arrays.equals(Programmers12981.solution(n3, words3), result3));
    }
}
