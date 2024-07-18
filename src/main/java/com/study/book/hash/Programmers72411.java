package com.study.book.hash;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers72411 {

    private static ArrayList<String> resultList = new ArrayList<>();

    private static String[] solution(String[] orders, int[] course) {
        String x = "ABC";
        combinations(0, x.toCharArray(), "");
        System.out.println(resultList);
        return resultList.toArray(new String[0]);
    }

    private static void combinations(int idx, char[] order, String result) {
        if (result.length() > 0) {
            resultList.add(result);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }

    public static void main(String[] args) {
        String[] orders1 = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = new int[]{2, 3, 4};
        String[] result1 = new String[]{"AC", "ACDE", "BCFG", "CDE"};


        String[] orders2 = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = new int[]{2, 3, 5};
        String[] result2 = new String[]{"ACD", "AD", "ADE", "CD", "XYZ"};

        String[] orders3 = new String[]{"XYZ", "XWY", "WXA"};
        int[] course3 = new int[]{2, 3, 4};
        String[] result3 = new String[]{"WX", "XY"};

        System.out.println(Arrays.equals(Programmers72411.solution(orders1, course1), result1));
        System.out.println(Arrays.equals(Programmers72411.solution(orders2, course2), result2));
        System.out.println(Arrays.equals(Programmers72411.solution(orders3, course3), result3));
    }
}
