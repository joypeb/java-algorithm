package inflearn.java_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Inf9_6Friends {
    //친구인가

    static int[] unf;

    public static void main(String[] args) {
        Inf9_6Friends inf = new Inf9_6Friends();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n+1];

        for(int i=0; i< unf.length; i++) {
            unf[i] = i;
        }

        for(int i=0; i<m; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();

            inf.union(s1,s2);
        }

        int resultS1 = inf.find(sc.nextInt());
        int resultS2 = inf.find(sc.nextInt());

        if(resultS1 == resultS2) System.out.println("YES");
        else System.out.println("NO");

    }

    public void union(int s1, int s2) {
        int fs1 = find(s1);
        int fs2 = find(s2);

        if(fs1 != fs2) unf[fs1] = fs2;
    }

    public int find(int s) {
        if(unf[s] == s) return s;
        else return unf[s] = find(unf[s]);
    }
}
