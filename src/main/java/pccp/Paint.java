package pccp;

import java.util.LinkedList;
import java.util.Queue;

class Color {
    int x, y;

    public Color(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Paint {
    static int[][] answer;
    static int[][] s;
    static int[] sx = {-1,0,1,0};
    static int[] sy = {0,1,0,-1};
    static void bfs(int x, int y, int c) {
        Queue<Color> q = new LinkedList<>();

        q.offer(new Color(x,y));
        int ec = answer[x][y];

        while(!q.isEmpty()) {
            Color color = q.poll();
            answer[color.x][color.y] = c;

            for(int i=0; i<4; i++) {
                int dx = color.x+sx[i];
                int dy = color.y+sy[i];

                if(0 <= dx && dx < answer.length && 0 <= dy && dy < answer[0].length && answer[dx][dy] == ec) {
                    q.offer(new Color(dx,dy));
                }
            }
        }
    }

    public static void main(String[] args) {
        Paint p = new Paint();

        answer = new int[][]{{1, 2, 4}, {2, 4, 4}, {4, 4, 4}};
        s = new int[][]{{0,2,8}};

        bfs(0,2,8);

        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer[0].length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}
