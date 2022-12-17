package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf8_4Permutation {
    //중복순열
    private static int n, m;
    private static int[] pm;

    private static void dfs(int l) {
        if(l == m) {
            for(int x : pm) {
                System.out.print(x +" ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=n; i++) {
                pm[l] = i;
                dfs(l+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];

        dfs(0);
    }
}
