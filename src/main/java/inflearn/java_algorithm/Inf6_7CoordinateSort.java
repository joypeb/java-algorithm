package inflearn.java_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class PointC implements Comparable<PointC> {
    public int x,y;

    PointC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(PointC o) {
        if(this.x == o.x)
            return this.y-o.y;
        else
            return this.x-o.x;
    }
}

public class Inf6_7CoordinateSort {

    //좌표 정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<PointC> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.add(new PointC(x,y));
        }

        Collections.sort(arr);

        for(PointC c : arr) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
