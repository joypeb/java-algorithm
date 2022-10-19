package CodeUp;

import java.util.Scanner;

public class CodeUp_1367 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=n-i-1; j>0; j--) {
                System.out.printf(" ");
            }
            for(int k=0; k<n; k++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }
}
