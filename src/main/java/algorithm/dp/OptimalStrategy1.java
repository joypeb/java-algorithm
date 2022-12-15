package algorithm.dp;

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

public class OptimalStrategy1 {
    //최적의 전략

    public static void main(String[] args) {
        int[] coins = {2,7,40,19};

        Pair[][] dp = new Pair[4][5];

        for(int i=0; i<coins.length-1; i++) {
            int left = Math.max(coins[i], coins[i+1]);
            int right = Math.min(coins[i], coins[i+1]);
            dp[i][i+1] = new Pair(left,right);
            System.out.println(dp[i][i+1].toString());
        }

        /*for(int i=0; i<coins.length; i++) {
            System.out.println(dp[i][i].toString());
        }*/
    }
}
