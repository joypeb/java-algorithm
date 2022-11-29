package algorithm.combination;

import java.util.HashSet;
import java.util.Set;

public class PrintAllNumber {
    public static final String chars ="011";
    public static Set<Integer> printNumber(Set<Integer> set, String prefix, int depth) {
        if (prefix.length() > depth) return set;
        if (prefix != "") set.add(Integer.parseInt(prefix));

        for (int i = 0; i < chars.length(); i++) {
            System.out.println(prefix + ", " + chars.charAt(i));
            printNumber(set, prefix + chars.charAt(i), depth);
        }
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> set = printNumber(new HashSet<>(), "", 3);
        System.out.println(set);
    }

}
