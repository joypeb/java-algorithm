package CodeUp;

import java.util.Scanner;

public class CodeUp_1064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int num4 = (num1 < num2 ? num1 : num2) < num3 ? (num1 < num2 ? num1 : num2) : num3;

        System.out.println(num4);
    }
}
