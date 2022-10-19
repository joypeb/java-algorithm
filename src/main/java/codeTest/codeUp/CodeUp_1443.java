package CodeUp;

import java.util.Scanner;

public class CodeUp_1443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<arr.length; i++) {
            int n = sc.nextInt();
            arr[i] = n;
        }

        for(int i=0; i< arr.length; i++) {
            inner : for(int j=i; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else{
                    break inner;
                }
            }
        }

        for(int x: arr) {
            System.out.println(x);
        }
    }
}
