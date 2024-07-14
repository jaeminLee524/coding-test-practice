package com.study.book.stack;

import java.util.Stack;

public class Programmers64061 {

    private static int solution(int[][] board, int[] moves) {

        // 해당 스택에 뽑은 인형의 값을 집어넣음
        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        // 뽑아야 하는 인형의 위치를 담고 있는 moves 만큼 반복
        for(int i = 0; i < moves.length; i++) {
            // 원하는 최초 moves 값을 뽑은 후 -1 = 인덱스 값으로 추출
            int findPos = moves[i] - 1;
            for(int j = 0; j < board.length; j++) {

                int data = board[j][findPos];
                if (data != 0) {
                    board[j][findPos] = 0;

                    // stack에서 푸시 하기 전에 현재 넣으려는 애랑 일치하면 pop && answer++;
                    if (!stack.isEmpty() && stack.peek() == data) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(data);
                    }

                    break;
                }
            }
        }

        return answer;
    }

    private static int solution2(int[][] board, int[] moves) {
        Stack<Integer>[] stacks = new Stack[board.length];
        int answer = 0;

        for(int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        // 스택에 board의 데이터를 역순으로 넣기
        for(int i = board.length -1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    stacks[j].push(board[i][j]);
                }
            }
        }

        // moves 요청에 따라 개별 스택에서 데이터 뽑기
        Stack<Integer> bucket = new Stack<>();
        for(int move : moves) {
            if (!stacks[move -1].isEmpty()) {
                Integer data = stacks[move - 1].pop();

                if (!bucket.isEmpty() && bucket.peek().equals(data)) {
                    bucket.pop();
                    answer +=2;
                } else {
                    bucket.push(data);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };

        int[] moves = new int[]{
            1, 5, 3, 5, 1, 2, 1, 4
        };

        int output = 4;

        System.out.println(output == Programmers64061.solution(input, moves));
        System.out.println(output == Programmers64061.solution2(input, moves));
    }
}
