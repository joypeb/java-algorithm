package CodeUp;

import java.util.Scanner;

public class CodeUp_1403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        for(int j=0; j<2; j++) {
            for(int k=0; k<num; k++) {
                System.out.println(arr[k]);
            }
        }
    }
}
