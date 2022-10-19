package CodeUp;

import java.util.Scanner;

public class CodeUp_1161 {
    public static String getEvenOdd(int n) {
        return n%2 == 0 ? "짝수" : "홀수";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.printf("%s+%s = %s\n", getEvenOdd(num1), getEvenOdd(num2), getEvenOdd(num1+num2));
    }
}
