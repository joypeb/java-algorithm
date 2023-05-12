package algorithm.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream {

    public static void main(String[] args) {
        int[] arr = {13,22,12,55,1,323,49};
        int[] arr2 = {};

        int max = IntStream.of(arr).max().orElse(0);
        int min = IntStream.of(arr).min().getAsInt();
        int sum = IntStream.of(arr)
                .map(n -> {
                    if (n > 50) {
                        n = 100;
                    }
                    return n;
                })
                .sum();

        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
    }
}
