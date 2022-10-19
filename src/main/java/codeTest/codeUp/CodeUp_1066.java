package CodeUp;

import java.util.Scanner;

public class CodeUp_1066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++) {
            int num = sc.nextInt();
            if(num % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}
