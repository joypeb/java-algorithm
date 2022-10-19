package CodeUp;

import java.util.Scanner;

public class CodeUp_1405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<num; i++) {
            for(int k=i; k<num; k++) {
                System.out.print(arr[k] + " ");
            }
            for(int j=0; j<i; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
