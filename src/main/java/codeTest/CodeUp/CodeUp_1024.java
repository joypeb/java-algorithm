package CodeUp;

import java.util.Scanner;

public class CodeUp_1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strArr = str.split("");
        for(String s : strArr) {
            System.out.println("'"+s+"'");
        }
    }
}
