package CodeUp;

import java.util.Scanner;

public class CodeUp_1093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] result = new int[24];

        for(int i=0; i< arr.length; i++) {
            arr[i] = sc.nextInt();
            result[arr[i]] += 1;
        }

        for(int j=1; j<result.length; j++) {
            System.out.printf("%d ",result[j]);
        }
    }
}
