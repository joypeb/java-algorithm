package algorithm.prime;

import java.util.Arrays;

public class Prime1 {
    public static void main(String[] args) {
        int[] arr = {13,17,19,23};
        boolean[] result = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
            inner:for(int j=2; j<arr[i]; j++) {
                if(j%arr[i] == 0) {
                    result[i] = false;
                    break inner;
                }
            }
            result[i] = true;
        }

        System.out.println(Arrays.toString(result));
    }
}
