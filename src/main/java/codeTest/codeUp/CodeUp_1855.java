package codeTest.codeUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeUp_1855 {

    public static int fibo(int n) {
        if(n == 1 || n == 2) return 1;
        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibo(n));

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);

        for(int i=2; i<n; i++){
            list.add(list.get(i-1) + list.get(i-2));
        }

        for(int x : list) {
            System.out.print(x + " ");
        }
    }
}
