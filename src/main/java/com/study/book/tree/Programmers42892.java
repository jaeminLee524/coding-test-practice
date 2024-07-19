package com.study.book.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers42892 {
    private static int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo);

        ArrayList<Integer> preOrderList = new ArrayList<>();
        Programmers42892.preOrder(root, preOrderList);

        ArrayList<Integer> postOrderList = new ArrayList<>();
        Programmers42892.postOrder(root, postOrderList);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private static Node makeBT(int[][] nodeinfo) {
        // 2차원 좌표 생성
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        // y축 기준으로 내림차순 정렬, x,y값이 같으면 x값 기준 오름차순
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2. y) {
                return Integer.compare(o1.x, o2.x);
            }

            return Integer.compare(o2.y, o1.y);
        });

        // 정렬된 0번째 index값이 root node
        Node root=  nodes[0];

        // x값, y값을 비교해서 2진 트리를 생성
        for(int i = 1; i < nodes.length; i++) {
            Node parent = root;
            while(true) {
                if(nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left =  nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if(parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes[0];
    }

    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }

        answer.add(curr.idx);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }

        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.idx);
    }

    private static class Node {
        private int x;
        private int y;
        private int idx;
        private Node left;
        private Node right;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        int[][] nodeinfo = new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] answer = new int[][]{{7, 4, 6, 9, 1, 8, 5, 2, 3}, {9, 6, 5, 8, 1, 4, 3, 2, 7}};

        int[][] solution = Programmers42892.solution(nodeinfo);
        System.out.println(Arrays.equals(answer[0], solution[0]));
        System.out.println(Arrays.equals(answer[1], solution[1]));
    }
}
