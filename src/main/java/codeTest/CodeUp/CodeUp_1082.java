package CodeUp;

import java.util.Scanner;

public class CodeUp_1082 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String c = sc.nextLine();
        int num = Integer.parseInt(c,16);

        for(int i=1; i<=15; i++) {
            System.out.printf("%X*%X=%X\n",num,i,num*i);
        }
    }
}
