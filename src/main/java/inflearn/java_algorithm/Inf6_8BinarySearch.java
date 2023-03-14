package inflearn.java_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Inf6_8BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int result = Arrays.binarySearch(arr,target);

        System.out.println(result+1);
    }
}
