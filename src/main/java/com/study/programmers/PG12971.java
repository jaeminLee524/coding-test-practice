package com.study.programmers;

public class PG12971 {

    public int solution(int[] sticker) {
        int length = sticker.length;

        if (length == 1) return sticker[0];
        if (length == 2) return Math.max(sticker[0], sticker[1]);

        int[] dp1 = new int[length];
        int[] dp2 = new int[length];

        // 1) 첫 번째 스티커를 뜯는 경우 (마지막 스티커는 뜯을 수 없음)
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 2) 첫 번째 스티커를 뜯지 않는 경우 (마지막 스티커도 가능)
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[length - 2], dp2[length - 1]);
    }

    public static void main(String[] args) {
        PG12971 pg12971 = new PG12971();

        int result1 = pg12971.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
        System.out.println(result1); // 36

        int result2 = pg12971.solution(new int[]{1, 3, 2, 5, 4});
        System.out.println(result2); // 8
    }
}

/*
N개의 스티커가 원형으로 연결되어 있습니다. 다음 그림은 N = 8인 경우의 예시입니다.
원형으로 연결된 스티커에서 몇 장의 스티커를 뜯어내어 뜯어낸 스티커에 적힌 숫자의 합이 최대가 되도록 하고 싶습니다.
단 스티커 한 장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없게 됩니다.
예를 들어 위 그림에서 14가 적힌 스티커를 뜯으면 인접해있는 10, 6이 적힌 스티커는 사용할 수 없습니다.
스티커에 적힌 숫자가 배열 형태로 주어질 때, 스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값을 return 하는 solution 함수를 완성해 주세요.
원형의 스티커 모양을 위해 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주합니다.
 */

/*
sticker	                        answer
[14, 6, 5, 11, 3, 9, 2, 10]	    36
[1, 3, 2, 5, 4]	                8
 */

// 아이디어
// 1. dp 배열을 사용하여 각 스티커를 뜯었을 때의 최대 합을 저장
// 2. 첫 번째 스티커를 뜯는 경우와 뜯지 않는 경우로 나누어 계산
// 3. 첫 번째 스티커를 뜯는 경우 마지막 스티커는 뜯지 않음
// 4. 첫 번째 스티커를 뜯지 않는 경우 마지막 스티커를 뜯을 수 있음
// 5. 두 경우의 최대 합을 비교하여 최종 결과 도출
// 6. 시간 복잡도 O(N), 공간 복잡도 O(N)
