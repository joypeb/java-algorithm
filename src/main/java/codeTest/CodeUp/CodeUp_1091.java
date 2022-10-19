package CodeUp;

import java.util.Scanner;

public class CodeUp_1091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();
        boolean check = true;
        int cnt = 1;

        while(check) {
            if(cnt == n) {
                System.out.println(a);
                check = false;
            }
            a = a*m+d;
            cnt++;
        }
    }
}
