package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_1854 {

    public static int solution(Long num, int sum) {
        if(num == 0) {
            return sum;
        }

        return solution(num/10, (int)(sum+num%10));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long num = sc.nextLong();

        int result = solution(num,0);

        System.out.println(result);
    }
}
