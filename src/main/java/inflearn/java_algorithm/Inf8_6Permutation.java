package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf8_6Permutation {
    //중복 x
    private static int n,m;
    private static int[] arr;

    static void permutation(int L, int[] ch, int[] result) {
        if(L == m) {
            for(int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i< arr.length; i++) {
                if(ch[i] != 1) {
                    ch[i] = 1;
                    result[L] = arr[i];
                    permutation(L+1, ch, result);
                    ch[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ch = new int[n];
        int[] result = new int[m];

        permutation(0, ch, result);
    }
}
