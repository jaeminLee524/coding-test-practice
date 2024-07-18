package com.study.book.tree;

import java.util.Arrays;

public class Example1 {

    private static String[] solution(int[] nodes) {

        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();

        return result;
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        String s = nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);

        return s;
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2 * idx + 1)  + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }

    public static void main(String[] args) {

        int[] nodes = new int[]{1, 2, 3, 4, 5, 6, 7};
        String[] result1 = new String[]{"1 2 4 5 3 6 7", "4 2 5 1 6 3 7", "4 5 2 6 7 3 1"};

        System.out.println(Arrays.equals(result1, Example1.solution(nodes)));
    }
}
