package CodeUp;

import java.util.Scanner;

public class CodeUp_1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = {10000,1000,100,10,1};

        for(int i=0; i<5; i++) {
            int num2 = num/arr[i] * arr[i];
            System.out.println("[" + num2 + "]");
            num -= num2;
        }
    }
}
