package CodeUp;

import java.util.Scanner;

public class CodeUp_1086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int b = sc.nextInt();

        float pre = ((long)w*h*b)/8;
        float result = (pre/1024)/1024;

        System.out.printf("%.2f MB",result);
    }
}
