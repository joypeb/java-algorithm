package CodeUp;

import java.util.Scanner;

public class CodeUp_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(":");
        System.out.println(Integer.parseInt(arr[1]));
    }
}
