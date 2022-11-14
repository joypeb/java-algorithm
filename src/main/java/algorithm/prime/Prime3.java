package algorithm.prime;

import java.util.Arrays;

public class Prime3 {
    public static int[] solution(int arr[]) {
        for(int i=2; i<arr.length; i++) {

            if(arr[i] == 0) {
                continue;
            }

            for(int j=i*2; j<arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[51];

        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        int[] result = solution(arr);

        for(int x: result) {
            if(x == 0) continue;
            else System.out.print(x + " ");
        }
    }
}
