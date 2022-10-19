package algorithm.star;

import java.util.Scanner;

public class Square {
    public void getSquare(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        Square square = new Square();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        square.getSquare(num);
    }
}
