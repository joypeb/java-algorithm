package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_1936 {
    //두 노드간의 거리
    public static int tree(int start, int end, int cnt) {
        if(start == end) return cnt;
        else if(start == 1) return cnt;
        else return tree(Math.floorDiv(start,2),end,cnt+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int result1 = tree(start,end,0);
        int result2 = tree(end, start, 0);
        System.out.println(result1 + result2);
    }
}
