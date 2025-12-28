package com.study.programmers;

import java.util.HashSet;
import java.util.Set;

public class PG131701 {

    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int length = elements.length;

        // 원형 수열의 모든 부분 수열 길이
        for (int subLength = 1; subLength <= length; subLength++) {
            // 시작 인덱스
            for (int start = 0; start < length; start++) {
                int sum = 0;
                // 부분 수열의 합 계산
                for (int i = 0; i < subLength; i++) {
                    sum += elements[(start + i) % length];
                }
                sums.add(sum);
            }
        }

        return sums.size();
    }

    public static void main(String[] args) {
        PG131701 pg131701 = new PG131701();
        int result1 = pg131701.solution(new int[]{7, 9, 1, 1, 4});
        System.out.println(result1); // 18
    }
}

/*
철호는 수열을 가지고 놀기 좋아합니다.
어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지 알아보고 싶어졌습니다.
원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다. 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 다음과 같습니다.
원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아집니다.
원형 수열의 모든 원소 elements가 순서대로 주어질 때, 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.
*/

/*
elements	    result
[7,9,1,1,4]	    18
*/

/*
입출력 예 #1
길이가 1인 연속 부분 수열로부터 [1, 4, 7, 9] 네 가지의 합이 나올 수 있습니다.
길이가 2인 연속 부분 수열로부터 [2, 5, 10, 11, 16] 다섯 가지의 합이 나올 수 있습니다.
길이가 3인 연속 부분 수열로부터 [6, 11, 12, 17, 20] 다섯 가지의 합이 나올 수 있습니다.
길이가 4인 연속 부분 수열로부터 [13, 15, 18, 21] 네 가지의 합이 나올 수 있습니다.
길이가 5인 연속 부분 수열로부터 [22] 한 가지의 합이 나올 수 있습니다.
이들 중 중복되는 값을 제외하면 다음과 같은 18가지의 수들을 얻습니다.
[1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 20, 21, 22]
*/



// set 에 담기
// elements 길이만큼 for문
//   부분 수열 길이만큼 for문
//     시작 인덱스부터 부분 수열 길이만큼 더하기 (원
//       인덱스가 elements.length 를 넘으면 % elements.length 해서 더하기)
//     set 에 담기
// return set.size
