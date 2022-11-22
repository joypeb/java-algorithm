package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_1853 {
    public static int solution(int num, int cnt) {
        if(cnt==0) {
            return num;
        }

        cnt--;

        return solution(num+cnt, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(solution(num,num));
    }
}
