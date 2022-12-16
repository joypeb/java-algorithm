package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf8_1SameSum {
    static int n = 0, sum = 0;
    static int[] arr;
    static String answer = "NO";
    static boolean flag = false;

    static void dfs(int L, int iSum) {
        if (flag) return;
        if (iSum > sum) return;
        if (L == n) {
            if ((sum - iSum) == iSum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(L + 1, iSum + arr[L]);
            dfs(L + 1, iSum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}
