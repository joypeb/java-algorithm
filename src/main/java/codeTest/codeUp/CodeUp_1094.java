package CodeUp;

import java.util.Scanner;

public class CodeUp_1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int temp = 0;
        int max = n-1;

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<arr.length; i++) {
            if(i >= max) {
                break;
            }

            temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            max--;
        }

        for(int x : arr) {
            System.out.printf("%d ",x);
        }
    }
}
