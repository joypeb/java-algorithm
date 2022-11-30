package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_1936 {
    //두 노드간의 거리
    public static int tree(int start, int end, int cnt) {
        if(start < end)
            return tree(start,Math.floorDiv(end,2), cnt+1);
        else if (start > end)
            return tree(Math.floorDiv(start,2),end, cnt+1);
        else return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int result = tree(start,end, 0);
        System.out.println(result);
    }
}
