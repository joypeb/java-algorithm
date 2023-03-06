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
            else if(result > n) continue;

            q.add(result+1);
            q.add(result+2);
        }
    }

    public long solution(int n) {
        long answer = 0;

        bfs(n);

        answer = cnt%1234567;

        return answer;
    }

    public static void main(String[] args) {
        LongJump longJump = new LongJump();

        System.out.println(longJump.solution(3));
    }
}
