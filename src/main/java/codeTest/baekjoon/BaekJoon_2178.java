package codeTest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_2178 {
    //bfs

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] arr = new int[x][y];

        for(int i=0; i<x; i++) {
            String ys = sc.next();

            for(int j=0; j<y; j++) {
                char c = ys.charAt(j);

                arr[i][j] = Character.getNumericValue(c);
            }
        }

        int[][] check = new int[x][y];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0});
        check[0][0] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            System.out.println(Arrays.toString(now));

            if(now[0] == x-1 && now[1] == y-1) break;

            for(int i=0; i<dx.length; i++) {
                int nx = dx[i]+now[0];
                int ny = dy[i]+now[1];

                if(nx >= 0 && ny >= 0 && nx < x && ny < y && arr[nx][ny] != 0 && check[nx][ny] == 0) {
                    check[nx][ny] = check[now[0]][now[1]]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        System.out.println(check[x-1][y-1]);
    }
}
