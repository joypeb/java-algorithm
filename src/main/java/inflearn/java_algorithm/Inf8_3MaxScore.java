package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf8_3MaxScore {
    //최대점수 구하기
    private static int n, m, total;
    private static int[] question, time;

    private static void dfs(int l, int t, int sum) {
        if(t > m) return;
        else if(total < sum) total = sum;
        if(l == n) return;

        dfs(l+1, t+time[l], sum+question[l]);
        dfs(l+1, t, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        question = new int[n];
        time = new int[n];

        for(int i=0; i<n; i++) {
            question[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        dfs(0,0,0);

        System.out.println(total);
    }
}
