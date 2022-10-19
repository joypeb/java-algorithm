package CodeUp;

import java.util.Scanner;

public class CodeUp_1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if(90 <= num) {
            System.out.println("A");
        } else if(70 <= num) {
            System.out.println("B");
        } else if(40 <= num) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }
}
