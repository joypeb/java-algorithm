package inflearn.java_algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Inf8_11MinMaze {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] maze, dis;

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i=0; i<4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        dis = new int[8][8];
        for(int i=1; i< maze.length; i++) {
            for(int j=1; j<maze[0].length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        bfs(1,1);

        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
