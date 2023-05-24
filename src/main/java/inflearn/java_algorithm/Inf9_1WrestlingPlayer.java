package inflearn.java_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{

    private int h;
    private int w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
}

public class Inf9_1WrestlingPlayer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Body> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            arr.add(new Body(h,w));
        }


        Collections.sort(arr);

        int max = 0;
        int cnt = 0;

        for(Body b : arr) {
            if(b.getW() > max) {
                cnt++;
                max = b.getW();
            }
        }

        System.out.println(cnt);
    }
}
