package algorithm.combination;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    public List<Character> alpha() {
        List<Character> alphaList = new ArrayList<>();

        for (int i=65; i<91; i++) {
            alphaList.add((char) i);
        }

        return alphaList;
    }

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();

        List<Character> alpha = alphabet.alpha();

        System.out.println(alpha.toString());
    }
}
