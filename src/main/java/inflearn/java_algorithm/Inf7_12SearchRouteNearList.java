package inflearn.java_algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Inf7_12SearchRouteNearList {
    //경로탐색 인접 리스트

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int answer = 0;

    static void dfs(int v) {
        if(v == n) answer++;
        else {
            for(int nextV : graph.get(v)) {
                if(ch[nextV] == 0) {
                    ch[nextV] = 1;
                    dfs(nextV);
                    ch[nextV] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n+1];

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        ch[1] = 1;

        dfs(1);
        System.out.println(answer);
    }
}
