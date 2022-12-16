package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf8_2Baduk {
    //바둑이 승차
    static int c, n, max;
    static int[] arr;

    static void dfs(int l, int sum) {
        if(sum >= c) return;
        else if(max < sum) max = sum;
        if(l == n) return;

        dfs(l+1, sum+arr[l]);
        dfs(l+1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0,0);

        System.out.println(max);

    }
}
