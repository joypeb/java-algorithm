package codeTest.codeUp;

import java.util.Scanner;

public class CodeUp_3001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i=0; i< arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int result = sc.nextInt();
        boolean tf = false;

        for(int i=0; i< arr.length; i++) {
            if(arr[i] == result) {
                System.out.println(i+1);
                tf = true;
                break;
            }
        }

        if(!tf) {
            System.out.println(-1);
        }
    }
}
