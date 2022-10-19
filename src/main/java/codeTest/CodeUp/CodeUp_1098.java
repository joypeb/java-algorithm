package CodeUp;

import java.util.Scanner;

public class CodeUp_1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] arr = new int[h+1][w+1];

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int l = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(d == 0) {
                for(int j=y; j<l+y; j++) {
                    arr[x][j] = 1;
                }
            } else {
                for(int k=x; k<l+x; k++) {
                    arr[k][y] = 1;
                }
            }
        }

        for(int i=1; i<h+1; i++) {
            for(int j=1; j<w+1; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
