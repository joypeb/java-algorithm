package inflearn.java_algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Inf8_5ExchangeCoin {
    //코인교환
    private static int n, m, total = 500;
    private static Integer[] coins;

    private static void dfs(int cnt, int sum) {
        if(total <= cnt) return;
        if(sum > m) return;
        if(sum == m) {
            total = Math.min(total,cnt);
        } else {
            for(int i=0; i<n; i++) {
                sum+=coins[i];
                dfs(cnt+1, sum);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        coins = new Integer[n];

        for(int i=0; i< coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());


        m = sc.nextInt();

        dfs(0,0);

        System.out.println(total);

    }
}
