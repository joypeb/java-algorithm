package algorithm.permutation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    //visited를 이용한 방법

    static int perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, int cnt) {
        //n개중에 r개를 뽑기때문에 깊이가 r이되면 탈출
        if(depth == r) {
            cnt++;
            return cnt+1;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr,output,visited,depth+1,n,r,cnt);
                visited[i] = false;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int n = arr.length;
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        int result = perm(arr,output,visited,0,n,3, 0);

        System.out.println(result);
    }
}
