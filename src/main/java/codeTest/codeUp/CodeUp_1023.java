package CodeUp;

import java.util.Scanner;

public class CodeUp_1023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] num = str.split("\\.");
        System.out.printf("%s\n%s",num[0],num[1]);
    }
}
