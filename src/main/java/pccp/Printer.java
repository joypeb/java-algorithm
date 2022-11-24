package pccp;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> pri = new LinkedList<>();
        Queue<Integer> priLoc = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            pri.offer(priorities[i]);
            priLoc.offer(i);
        }

        Integer[] arr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());



        return answer;
    }
}
