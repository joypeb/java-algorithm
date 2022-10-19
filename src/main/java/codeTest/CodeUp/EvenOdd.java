package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num2 = Integer.parseInt(bf.readLine());

        int num = sc.nextInt();

        if(num%2 != 0) System.out.println("odd");
        else System.out.println("even");
    }
}
