package CodeUp;

import java.util.Scanner;

public class CodeUp_1859 {
    public void triangle(int num, String now) {
       if(num == now.length()-1) {
           return;
       }
        System.out.println(now);
       triangle(num, now + "*");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        CodeUp_1859 codeUp_1859 = new CodeUp_1859();
        codeUp_1859.triangle(num, "*");
    }
}
