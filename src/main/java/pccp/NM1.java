package pccp;

import java.util.Scanner;

public class NM1 {

    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int m) {
        if(depth == m) {
            for(int i=0; i<output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = i+1;
                perm(arr,output,visited,depth+1,n,m);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int[] output = new int[m];
        boolean[] visited = new boolean[n];

        perm(arr,output,visited,0,n,m);

    }
}
