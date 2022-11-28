package pccp;

import java.util.HashMap;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> genresHash = new HashMap<>();

        for(int i=0; i< genres.length; i++) {
            genresHash.put(genres[i], genresHash.getOrDefault(genres[i],0)+plays[i]);
        }

        System.out.println(genresHash.toString());
        return answer;
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(bestAlbum.solution(genres,plays));
    }
}
