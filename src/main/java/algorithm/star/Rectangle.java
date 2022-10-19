package algorithm.star;

import java.util.Scanner;

public class Rectangle {
    public void getRectangle(int x, int y) {
        for(int i=0; i<y; i++) {
            for(int j=0 ;j<x; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Rectangle rectangle = new Rectangle();

        rectangle.getRectangle(x,y);
    }
}
