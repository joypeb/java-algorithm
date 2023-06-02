package inflearn.java_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Schedule implements Comparable<Schedule>{

    int m,d;

    public Schedule(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Schedule o) {
        if(o.d == this.d) return o.m - this.m;
        return o.d - this.d;
    }
}

public class Inf9_4BestIncomeSchedule {
    //최대 수입 스케쥴
    /*
    *
    * 60 3
    * 50 2
    * 40 2
    * 30 3
    * 30 1
    * 20 1
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = 0;

        ArrayList<Schedule> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();

            arr.add(new Schedule(m,d));
            max = Math.max(max, d);
        }

        System.out.println(solution(arr, max));
    }

    public static int solution(ArrayList<Schedule> arr, int max) {
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(arr);

        int j = 0, n = arr.size();

        for(int i=max; i>=1; i--) {
            for(; j<n; j++) {
                if(arr.get(j).d < i) break;
                pq.offer(arr.get(j).m);
            }
            if(!pq.isEmpty())
                result += pq.poll();
        }

        return result;
    }
}
