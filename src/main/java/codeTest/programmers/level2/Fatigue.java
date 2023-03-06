package codeTest.programmers.level2;

import java.util.Arrays;

public class Fatigue {
    //arr : 배열
    //output : 출력을 위한 배열
    //visited : 방문한적이 있는지 확인을 위한 배열
    //depth : 깊이 체크용
    //r : 어디까지 조합할것인가

    static int K;
    static int ANSWER;
    static int[][] DUNGEONS;
    static void per2(int len, int[] output, boolean[] visited, int depth) {
        if(depth == len) {
            int k = K, cnt = 0;
            for(int x : output) {
                if(k <= 0) break;
                if(k >= DUNGEONS[x][0]) {
                    k -= DUNGEONS[x][1];
                    cnt++;
                }
            }
            if(cnt > ANSWER) {
                ANSWER = cnt;
            }
            return;
        }

        for(int i = 0; i < len; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = i;
                per2(len, output, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        K = k;
        DUNGEONS = dungeons;
        int len = dungeons.length;
        int[] output = new int[len];
        boolean[] visited = new boolean[len];

        per2(len,output,visited,0);

        return ANSWER;
    }
}
