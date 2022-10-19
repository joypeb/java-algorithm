package CodeUp;

import java.util.Scanner;

public class CodeUp_1097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] checker = new int[20][20];

        for(int i=1; i<20; i++) {
            for(int j=1; j<20; j++) {
                checker[i][j] = sc.nextInt();
            }
        }

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j=1; j<20; j++) {
                if(checker[x][j] == 1) {
                    checker[x][j] = 0;
                } else if(i == y){

                } else {
                    checker[x][j] = 1;
                }
            }

            for(int k=1; k<20; k++) {
                if(checker[k][y] == 1) {
                    checker[k][y] = 0;
                } else if(i ==x){

                } else {
                    checker[k][y] = 1;
                }
            }
        }

        for(int i=1; i<20; i++) {
            for(int j=1; j<20; j++) {
                System.out.printf("%d ", checker[i][j]);
            }
            System.out.println();
        }
    }
}
