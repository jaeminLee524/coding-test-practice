package com.study.book.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Programmers42579 {

    private static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> totalPlaysMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                totalPlaysMap.put(genre, 0);
            }

            genreMap.get(genre).add(new int[]{i, play});
            totalPlaysMap.put(genre, totalPlaysMap.get(genre) + play);
        }

        ArrayList<Integer> result = new ArrayList<>();

        Stream<Entry<String, Integer>> sortedGenre = totalPlaysMap.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);

            sortedSongs.forEach(song -> result.add(song[0]));
        });

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        int[] result = new int[]{4, 1, 3, 0};

        System.out.println(Arrays.equals(Programmers42579.solution(genres, plays), result));
    }
}
