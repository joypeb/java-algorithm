package algorithm.combination;

import java.util.Arrays;

public class combination {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        boolean[] visited = new boolean[arr.length];

        comb(arr,visited,0,2);
    }

    public static void comb(int[] arr, boolean[] visited, int start, int cnt) {
        if(cnt == 0) {
            print(arr, visited);
            return;
        }

        for(int i=start; i<arr.length; i++) {

            visited[i] = true;

            comb(arr,visited,i+1,cnt-1);

            visited[i] = false;
        }
    }

    public static void print(int[] arr, boolean[] visited) {
        for(int i=0; i<arr.length; i++) {
            if(visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
