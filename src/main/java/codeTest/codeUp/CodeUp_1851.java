package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_1851 {
    public static void solution(int num) {
        if(num == 0) return;
        System.out.print("*");
        solution(num-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        solution(num);
    }
}
