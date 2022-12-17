package inflearn.java_algorithm;

import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class Inf8_7Memoization {
    //static int n, r;

    static int memo(int n, int r) {
        if(r == 1) return n;
        if(r == 0 || n == r) return 1;
        return memo(n-1,r-1) + memo(n-1,r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int result = memo(n,r);

        System.out.println(result);
    }
}
