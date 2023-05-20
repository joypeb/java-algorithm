package codeTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_12865 {
    //평범한 배낭

    /*
    * 0 - 1 - 1 - 1 - 1 - 1
    * 4 - 6 - 4 - 3 - 5 - 5
    *
    * */


    static int[] DP;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        int[][] bag = new int[n][2];

        for(int i=0; i<n; i++) {
            String[] innerBag = br.readLine().split(" ");

            bag[i][0] = Integer.parseInt(innerBag[0]);
            bag[i][1] = Integer.parseInt(innerBag[1]);
        }


        int result = solution(bag, k);
        System.out.println(result);
    }

    public static int solution(int[][] bag, int k) {

        DP = new int[k+1];

        dfs(bag, k, 0, 0, 0);

        return result;
    }

    public static void dfs(int[][] bag, int k, int sum, int weight, int l) {
        if(sum > k) {
            return;
        }  else if(sum == k) {
            result = Math.max(result, weight);
        }

        if(DP[sum] != 0) {

        }

        for(int i=l; i<bag.length; i++) {

            dfs(bag, k, sum+bag[i][0], weight+bag[i][1], i);
        }
    }
}
