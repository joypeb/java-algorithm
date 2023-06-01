package inflearn.java_algorithm;

import javax.annotation.processing.Completion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    private int s;
    private int e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public int getS() {
        return s;
    }

    public int getE() {
        return e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }
}

public class Inf9_2OfficeRoom {
    //회의실 배정


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Time> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr.add(new Time(s,e));
        }

        Collections.sort(arr);

        int cnt = 0;
        int st = 0;
        for(Time t : arr) {
            if(t.getS() >= st) {
                cnt++;
                st = t.getE();
            }
        }

        System.out.println(cnt);
    }
}
