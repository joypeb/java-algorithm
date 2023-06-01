package inflearn.java_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Wedding implements Comparable<Wedding> {
    int s,e;

    public Wedding(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Wedding o) {
        if(this.s == o.s) return o.e - this.e;
        return this.s - o.s;
    }
}

public class Inf9_3Wedding {
    //결혼식
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Wedding> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr.add(new Wedding(s,e));
        }

        Collections.sort(arr);

        int cnt = 0, max = 0;
        int start = 0, end = 0;


        for(Wedding w : arr) {
            if(start <= w.s && w.s < end) {
                cnt++;
                max = Math.max(cnt, max);
            } else {
                cnt = 1;
                start = w.s;
                end = w.e;
            }
            System.out.println(w.s + ", " + w.e + ", " + cnt);
        }

        System.out.println(max);
    }
}
