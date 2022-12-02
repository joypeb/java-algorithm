package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_2203 {

    static long primeFacto(long n) {
        long result = 0;

        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            while(n%i == 0) {
                result = i;
                n/=i;
            }
        }
        if(n != 1) {
            result = n;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        System.out.println(primeFacto(n));
    }
}
