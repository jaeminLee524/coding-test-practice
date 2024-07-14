package com.study.book.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Programmers76502 {

    private static int solution(String s) {
        int answer = 0;

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        int originalStringLen = s.length();
        s = s + s;

        A: for(int i = 0; i < originalStringLen; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i;  j < i + originalStringLen; j++) {
                char target = s.charAt(j);
                // if 여는 괄호라면 stack에 넣기
                if (!map.containsKey(target)) {
                    stack.push(target);
                } else {
                    // else 닫기 괄호라면 stack에서 pop한게 map의 i번째 key에 해당하는 value인지
                    if (stack.isEmpty() || !stack.pop().equals(map.get(target))) {
                        continue A;
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String input1 = "[](){}";
        int output1 = 3;

        String input2 = "}]()[{";
        int output2 = 2;

        String input3 = "[)(]";
        int output3 = 0;

        String input4 = "}}}";
        int output4 = 0;

        System.out.println(Programmers76502.solution(input1) == output1);
        System.out.println(Programmers76502.solution(input2) == output2);
        System.out.println(Programmers76502.solution(input3) == output3);
        System.out.println(Programmers76502.solution(input4) == output4);
    }
}
