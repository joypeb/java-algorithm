package CodeUp;

import java.util.Scanner;

public class CodeUp_1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("\\.");
        System.out.println(arr[2] + "-" + arr[1] + "-" + arr[0]);
    }
}
