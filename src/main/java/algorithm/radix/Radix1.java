package algorithm.radix;

import java.util.Arrays;

public class Radix1 {

    public static void main(String[] args) {
        int[] num = {7,4,5,9,1,0};
        int[] arr = new int[10];

        for(int i=0; i<num.length; i++) {
           arr[num[i]] = num[i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
