package inflearn.java_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Wedding implements Comparable<Wedding> {
    int t, c;

    public Wedding(int t, int c) {
        this.t = t;
        this.c = c;
    }

    @Override
    public int compareTo(Wedding o) {
        if(this.t == o.t) return o.c - this.c;
        return this.t - o.t;
    }
}

public class Inf9_3Wedding{

    //결혼식
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Wedding> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr.add(new Wedding(s,0));
            arr.add(new Wedding(e,1));
        }

        Collections.sort(arr);

        int cnt = 0, max = 0;
        int start = 0, end = 0;

        for(Wedding w : arr) {
            if(w.c != 1) {
                cnt++;
            } else {
                cnt--;
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);

    }
}
