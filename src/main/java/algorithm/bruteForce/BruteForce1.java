package algorithm.bruteForce;

public class BruteForce1 {
    static int N = 4;
    static int[] nums = {1,2,3,4};

    public static int solve(int cnt, int used, int val) {
        if(cnt == 2) return val;

        int ret = 0;

        for(int i=0; i<N; i++) {
            if((used & 1 << i) != 0) continue;
            ret = Math.max(ret, solve(cnt+1,used | 1 << i, val * 10 + nums[i]));
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] nums = {1,2,3,4};
    }
}
