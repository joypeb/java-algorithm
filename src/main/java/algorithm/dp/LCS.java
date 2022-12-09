package algorithm.dp;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String st1 = "ABCDCBA"; //열
        String st2 = "DCABDC"; //행

        //st2인 DCABDC를 i로 놓고 바깥쪽에서 반복할 예쩡
        //st1을 j로 놓고 안쪽에서 반복할 예정

        int[][] dp = new int[st2.length()+1][st1.length()+1];

        for(int i=1; i<=st2.length(); i++) {
            for(int j=1; j<=st1.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                if(st1.charAt(j-1) == st2.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = Math.max(up,left);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }


    }
}
