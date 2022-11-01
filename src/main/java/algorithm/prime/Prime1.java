package algorithm.prime;

import java.util.Arrays;

public class Prime1 {
    public static void main(String[] args) {
        int[] arr = {13,17,19,23};
        boolean[] result = new boolean[arr.length];
        boolean[] result2 = new boolean[arr.length];
        boolean[] result3 = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
            //자기 자신 전까지
            inner:for(int j=2; j<arr[i]; j++) {
                if(j%arr[i] == 0) {
                    result[i] = false;
                    break inner;
                }
            }
            result[i] = true;

            //절반까지
            inner2:for(int j=2; j<arr[i]/2; j++) {
                if(j%arr[i] == 0) {
                    result2[i] = false;
                    break inner2;
                }
            }
            result2[i] = true;

            //루트까지
            inner3:for(int j=2; j<Math.sqrt(arr[i]); j++) {
                if(j%arr[i] == 0) {
                    result3[i] = false;
                    break inner3;
                }
            }
            result3[i] = true;
        }

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}
