package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf8_10Maze1 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] maze;
    static int cnt = 0;

    static void dfs(int x, int y) {
        if(x == 7 && y ==7) cnt++;
        else {
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    dfs(nx,ny);
                    maze[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        for(int i=1; i< maze.length; i++) {
            for(int j=1; j<maze[0].length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        maze[1][1] = 1;
        dfs(1,1);

        System.out.println(cnt);
    }
}
