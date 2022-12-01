package codeTest.programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = {};

        PriorityQueue<Integer>[] arr = new PriorityQueue[score.length];

        for(int i=0; i< arr.length; i++) {
            inner : for(int j=i; j<i+k; j++) {
                arr[j].add(score[i]);
                if(arr[j].size() >= k) break inner;
                if(j+1 == arr.length) break inner;
            }
        }

        for(int i=0; i< arr.length; i++) {
            System.out.println(arr[i].toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        HallOfFame hallOfFame = new HallOfFame();

        int[] arr = {10, 100, 20, 150, 1, 100, 200};
        int[] result = hallOfFame.solution(3,arr);

        System.out.println(Arrays.toString(result));
    }
}
