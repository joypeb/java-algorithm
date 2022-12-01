package algorithm.permutation;

import java.util.Arrays;

public class Permutation1 {

    static void permutation(int[] arr, int m, int n, boolean[] visited, int cnt) {
        if(cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i=1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(arr,m,n,visited,cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 2;

        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=4; i++) {
            int[] arr = new int[i];
            permutation(arr, i, n, visited, 0);
        }
    }
}
