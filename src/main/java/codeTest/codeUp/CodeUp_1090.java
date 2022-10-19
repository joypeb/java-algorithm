package CodeUp;

import java.util.Scanner;

public class CodeUp_1090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int cnt = 1;
        boolean c = true;

        while(c) {
            if(cnt == n3) {
                System.out.println(n1);
                c = false;
            }

            n1 *= n2;
            cnt++;
        }
    }
}
