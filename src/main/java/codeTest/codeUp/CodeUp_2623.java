package codeTest.codeUp;

import java.awt.print.Pageable;
import java.util.Scanner;

public class CodeUp_2623 {
    //최대공약수 구하기

    public static int gcd(int n, int m) {
       if(n > m) {
           return gcd(n-m,m);
       } else if (m > n) {
           return gcd(m-n, n);
       } else {
           return m;
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = gcd(n,m);

        System.out.println(result);

        while(true) {
            if(n > m) {
                n = n-m;
            } else if(m > n) {
                m = m-n;
            } else {
                break;
            }
        }
        System.out.println(m);
    }
}
