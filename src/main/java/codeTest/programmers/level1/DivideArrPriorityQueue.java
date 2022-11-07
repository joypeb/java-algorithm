package codeTest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DivideArrPriorityQueue {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor == 0) {
                pq.add(arr[i]);
            }
        }

        if(pq.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[pq.size()];
            int cnt = 0;
            while(!pq.isEmpty()) {
                answer[cnt++] = pq.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        DivideArrPriorityQueue divideArrPriorityQueue = new DivideArrPriorityQueue();
        int[] a = {5, 10, 15, 3};
        int p = 5;

        int[] arr = divideArrPriorityQueue.solution(a, p);

        System.out.println(Arrays.toString(arr));
    }
}
