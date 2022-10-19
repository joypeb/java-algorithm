package CodeUp;

import java.util.Scanner;

public class CodeUp_1099 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[11][11];

        for(int i=1; i<11; i++) {
            for(int j=1; j<11; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        boolean tf = true;
        int x = 2, y = 2;

        if(arr[x][y] != 2) {
            while(tf) {
                arr[x][y] = 9;

                if(arr[x][y+1] == 1) {
                    x++;
                } else if(arr[x][y+1] == 0){
                    y++;
                } else {
                    y++;
                }

                if(arr[x][y] == 2) {
                    arr[x][y] = 9;
                    tf = false;
                }

                if(x==9 && y ==9) {
                    arr[x][y] = 9;
                    tf =false;
                }
            }
        } else {
            arr[x][y] = 9;
        }

        for(int i=1; i<11; i++) {
            for(int j=1; j<11; j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}
