package CodeUp;

import java.util.Scanner;

public class CodeUp_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int s = sc.nextInt();

        float pre = ((long)h*b*c*s)/8;
        float result = (pre/1024)/1024;

        System.out.printf("%.1f MB",result);
    }
}
