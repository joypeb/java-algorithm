package inflearn.java_algorithm;

import java.util.Arrays;

public class Fibo7_4 {
    static int[] fibo;
    static int dfs(int n) {
        if(n == 1 ) return fibo[n-1] = 1;
        else if (n == 2) return fibo[n-1] = 1;
        else {
            return fibo[n-1] = dfs(n-1) + dfs(n-2);
        }
    }

    public static void main(String[] args) {
        int n = 45;

        fibo = new int[n-1];

        dfs(n-1);

        System.out.println(fibo[fibo.length-1] + fibo[fibo.length-2]);
    }
}
