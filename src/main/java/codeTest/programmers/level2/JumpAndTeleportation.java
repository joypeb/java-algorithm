package codeTest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class JumpAndTeleportation {
    /*
    * bfs(효율딸림)
    * 1과 2는 무조건 에너지를 1소모하기때문에 바로 리턴
    * 그 다음부터 에너지를 소모하고 한칸 점프하기, 순간이동하기 두 종류를 큐에 담고 while문을 돌린다
    * 이미 나왔던 숫자는 check배열에 넣어서 중복으로 큐에 들어가는 것을 방지하고 n보다 큰 수가 check에 들어가지않게 n보다 작은지 확인한다
    *
    * 홀짝
    * 순간이동은 무조건 *2로 짝수이다. 그렇기때문에 홀수인경우는 무조건 한칸 앞으로 가야된다
    * n이 홀수인지 짝수인지 확인하고 홀수일경우 무조건 한칸 앞으로 가야되기때문에 ans++를 해주고 n--를 해준다
    * 짝수일경우 2로 나눈다
    * n이 0이될때까지 반복한다
    *
    * */
    public int solutionBFS(int n) {
        int ans = 0;
        int[] check = new int[n+1];

        Queue<int[]> q = new LinkedList<>();

        if(n == 1 || n == 2) return 1;

        q.add(new int[]{2,1});

        jt:while(!q.isEmpty()) {
            int[] num = q.poll();
            if(num[0] == n) {
                ans = num[1];
                break jt;
            } else {
                check[num[0]] = 1;
            }

            int plus = num[0] + 1;
            int multi = num[0] * 2;

            if(multi <= n && check[multi] != 1)
                q.add(new int[]{multi, num[1]});

            if(plus <= n && check[plus] != 1)
                q.add(new int[]{plus, num[1]+1});
        }


        return ans;
    }

    public int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(oddEven(n)) {
                ans++;
                n--;
            }
            n/=2;
        }

        return ans;
    }

    public boolean oddEven(int num) {
        //홀수 true, 짝수 false
        if(num % 2 == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        JumpAndTeleportation jumpAndTeleportation = new JumpAndTeleportation();

        int n = 1000000000;

        System.out.println(jumpAndTeleportation.solution(n));
    }
}
