package com.study.programmers;

import java.util.Arrays;

public class PG131705Opt {

    /**
     * O^3 풀이법을 투 포인터 기법을 통해 O^2 풀이법으로 최적화
     */
    public int solution(int[] number) {
        int answer = 0;
        int length = number.length;

        // 배열을 오름차순으로 정렬
        Arrays.sort(number);

        for (int i = 0; i < length - 2; i++) {
            // 중복되는 수는 건너뛰기 (i가 중복된 값일 경우)
            if (i > 0 && number[i] == number[i - 1]) {
                continue;
            }

            int left = i + 1;  // 왼쪽 포인터
            int right = length - 1;  // 오른쪽 포인터

            while (left < right) {
                int sum = number[i] + number[left] + number[right];

                if (sum == 0) {
                    // 합이 0이면 답 증가
                    answer++;

                    // 중복을 피하기 위해 좌우 포인터를 이동
                    while (left < right && number[left] == number[left + 1]) {
                        left++;
                    }
                    while (left < right && number[right] == number[right - 1]) {
                        right--;
                    }

                    // 포인터 이동
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 합이 0보다 작으면 왼쪽 포인터를 증가
                    left++;
                } else {
                    // 합이 0보다 크면 오른쪽 포인터를 감소
                    right--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PG131705Opt pg131705 = new PG131705Opt();

        int result1 = pg131705.solution(new int[]{-2, 3, 0, 2, -5});
        System.out.println(result1); // 2

        int result2 = pg131705.solution(new int[]{-3, -2, -1, 0, 1, 2, 3});
        System.out.println(result2); // 5

        int result3 = pg131705.solution(new int[]{-1, 1, -1, 1});
        System.out.println(result3); // 0
    }
}


/*
한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다.
이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다.
예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때, 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다.
또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.

한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
 */


/*
number	                  result
[-2, 3, 0, 2, -5]	        2
[-3, -2, -1, 0, 1, 2, 3]	5
[-1, 1, -1, 1]	            0
 */

/*
-2 3 0
-2 3 2
-2 3 -5
-2 0 2      v
-2 0 -5
-2 2 -5
3 0 2
3 0 -5
3 2 -5      v
0 2 -5
*/

// 1. 조합으로 3개씩 뽑기
// 2. 합이 0인지 확인
// 3. 카운트
