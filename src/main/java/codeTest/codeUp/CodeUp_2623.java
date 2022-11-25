package codeTest.codeUp;

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

        int result = 0;

        if(n > m) result = gcd(n,m);
        else result = gcd(m,n);

        System.out.println(result);
    }
}
