package com.study.book.array;

import java.util.Set;
import java.util.HashSet;

public class Programmers49994 {

    private static int solution(String dirs) {

        // 1. 현재 좌표값 초기화
        int x = 0;
        int y = 0;

        // 2. U, D, L, R 별 좌표 초기화
        int[] U = new int[]{0, 1};
        int[] D = new int[]{0, -1};
        int[] L = new int[]{-1, 0};
        int[] R = new int[]{1, 0};

        // 2-1 초행길 초기화
        int moveCount = 0;
        Set<String> paths = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            // 3. 매개변수의 값에 따라 현재 위치 찾기
            char dir = dirs.charAt(i);
            int[] move;

            switch (dir) {
                case 'U':
                    move = U;
                    break;
                case 'D':
                    move = D;
                    break;
                case 'L':
                    move = L;
                    break;
                case 'R':
                    move = R;
                    break;
                default:
                    continue;
            }

            // 4. 현재 위치의 값이 유효한지 체크, 유효하지 않으면 다음 좌표로
            int newX = x + move[0];
            int newY = y + move[1];

            if (newX < -5 || newX > 5 || newY < -5 || newY > 5) {
                continue;
            }

            String path1 = x + " " + y + " " + newX + " " + newY;
            String path2 = newX + " " + newY + " " + x + " " + y;

            // 5. 방문한 위치 기록 및 초행길 증감
            paths.add(path1);
            paths.add(path2);
            moveCount++;

            x = newX;
            y = newY;
        }

        // 6. 좌표 업데이트
        System.out.println("paths = " + paths);
        return moveCount;
    }

    public static void main(String[] args) {

        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        int answer1 = 7;
        int answer2 = 7;

        System.out.println(answer1 == Programmers49994.solution(dirs1));
        System.out.println(answer2 == Programmers49994.solution(dirs2));
    }
}
// paths = [0 1 -1 1, 0 1 1 1, 0 1 0 0, -1 2 0 2, 1 1 1 2, -1 2 -1 1, 1 1 0 1, 0 2 1 2, -1 1 0 1, 0 0 0 1, 1 2 0 2, 1 2 1 1, 0 2 -1 2, -1 1 -1 2]
// paths = [0 1 -1 1, 0 1 1 1, 0 1 0 0, -1 2 0 2, 1 1 1 2, -1 2 -1 1, 1 1 0 1, 0 2 1 2, -1 1 0 1, 0 0 0 1, 1 2 0 2, 1 2 1 1, 0 2 -1 2, -1 1 -1 2]