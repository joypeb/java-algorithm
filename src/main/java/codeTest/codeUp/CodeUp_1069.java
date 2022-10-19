package CodeUp;

import java.util.Scanner;

public class CodeUp_1069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().charAt(0);

        switch (c) {
            case 'A':
                System.out.println("best!!!");
                break;
            case 'B' :
                System.out.println("good!!");
                break;
            case 'C' :
                System.out.println("run!");
                break;
            case 'D':
                System.out.println("slowly~");
                break;
            default:
                System.out.println("what?");
                break;
        }
    }
}
