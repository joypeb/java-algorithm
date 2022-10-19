package CodeUp;

import java.util.Scanner;

public class CodeUp_4596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];
        int cnt1 = 0;
        int cnt2 = 0;
        int result = 0;

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                arr[i][j] = sc.nextInt();
                if(result < arr[i][j]) {
                    result = arr[i][j];
                    cnt1 = i;
                    cnt2 = j;
                }
            }
        }

        System.out.println(result + "\n" + (cnt1+1) + " " + (cnt2+1));
    }
}
