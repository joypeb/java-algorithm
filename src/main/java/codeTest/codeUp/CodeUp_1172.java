package CodeUp;

import java.util.Arrays;
import java.util.Scanner;

public class CodeUp_1172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int[] arr = {num1,num2,num3};
        Arrays.sort(arr);

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
