package CodeUp;

import java.util.Arrays;
import java.util.Scanner;

public class CodeUp_1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] arr = {n1,n2,n3};
        Arrays.sort(arr);

        int result1 = arr[2]*arr[1]/getGCD(arr[2],arr[1]);
        int result2 = 0;

        if(result1 > arr[0]) {
            result2 = result1*arr[0]/getGCD(result1,arr[0]);
        } else {
            result2 = result1*arr[0]/getGCD(arr[0],result2);
        }

        System.out.println(result2);
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}
