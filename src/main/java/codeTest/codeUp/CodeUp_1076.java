package CodeUp;

import java.util.Scanner;

public class CodeUp_1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().charAt(0);

        for(int i=97; i<=(int)c; i++) {
            System.out.print((char)i + " ");
        }
    }
}
