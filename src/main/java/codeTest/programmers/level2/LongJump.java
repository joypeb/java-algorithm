package codeTest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class LongJump {
    //멀리뛰기
    static long cnt = 0;

    static void bfs(int n) {
        Queue<Long> q = new LinkedList<>();

        q.add(1L);
        q.add(2L);

        while(!q.isEmpty()) {
            long result = q.poll();
            if(result == n) cnt+=1;

            if(result+1 <= n)
                q.add(result+1);
            if(result+2 <= n)
                q.add(result+2);
        }
    }

    static void dfs(int n, int sum) {
        if(sum == n) {
            cnt+=1;
            return;
        }

        if(sum > n) return;

        dfs(n,sum+1);
        dfs(n,sum+2);
    }

    public long solution(int n) {
        long answer = 0;

        //bfs(n);

        dfs(n,0);
        answer = cnt%1234567;

        return answer;
    }

    public static void main(String[] args) {
        LongJump longJump = new LongJump();

        System.out.println(longJump.solution(100));
    }
}
