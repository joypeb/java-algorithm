package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_1912 {

    public static int sol(int n, int c) {
        if(c == 1) return n;
        c--;
        return sol(n*c,c--);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sol(n, n));
    }
}
