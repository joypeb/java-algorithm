package codeTest.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    /*
    1. 점을 이은 연결선 하나가 하나의 네트워크다 -> answer++
    2. 이미 연결된 네트워크는 다시 방문할 필요가 없으므로 체크용 배열을 생성한다
    3. 체크 배열이 0일경우 해당 네트워크는 비어있기때문에 들어가서 확인한다
    4. bfs를 이용할것이기때문에 큐를 생성하고 큐에 해당 네트워크의 위치를 집어넣고 체크배열을 1로 변경한다
    5. 큐가 비어있을때까지 반복문을 돌린다
    6. 큐에서 네트워크의 위치를 뺀다
    7. 해당 위치의 네트워크는 다른 네트워크들과 연결되어있는 배열을 들고있다. 그리고 그 배열의 길이는 n이다. 그러므로 해당 길이만큼 반복문들 돌려준다
    8. 거기서 computers의 값이 1인것 즉 다른 네트워크들과 연결되어있고 check배열도 0일경우 완전히 새로운 네트워크이기 때문에 큐를 추가하고 check배열에도 값을 추가시킨다
    9. 반복문이 끝날경우 bfs가 끝난것이고 네트워크 하나의 위치가 파악되었기때문에 answer++한다.
     */

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] check = new int[n];

        for(int i=0; i<check.length; i++) {
            if(check[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                check[i] = 1;

                while(!q.isEmpty()) {
                    int com = q.poll();
                    for(int j=0; j<n; j++) {
                        if(computers[com][j] == 1 && check[j] == 0) {
                            q.add(j);
                            check[j] = 1;
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}
