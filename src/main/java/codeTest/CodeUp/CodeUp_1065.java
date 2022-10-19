package CodeUp;

import java.util.Scanner;

public class CodeUp_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int[] arr = {num1, num2, num3};

        for(int i=0; i<3; i++) {
            if(arr[i] % 2 == 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
