package algorithm.prime;

import java.util.Arrays;

public class Prime1 {
    public static void main(String[] args) {
        int[] arr = {13,17,19,80};
        boolean[] result = new boolean[arr.length];
        boolean[] result2 = new boolean[arr.length];
        boolean[] resultSqrt = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
           result[i] = prime(arr[i]);
           result2[i] = prime2(arr[i]);
           resultSqrt[i] = primeSqrt(arr[i]);
        }

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(resultSqrt));
    }

    public static boolean prime(int num) {
        for(int i=2; i<num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean prime2(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean primeSqrt(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
