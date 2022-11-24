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

        Arrays.sort(priorities);

        //[1,2,2,3]

        while(true) {
            if(priorities[priorities.length-1-answer] == pri.peek()) {
                if(location == pri.peek()) {
                    answer++;
                    break;
                }
                pri.poll();
                priLoc.poll();

                answer++;
            } else {
                pri.offer(pri.poll());
                priLoc.offer(priLoc.poll());
            }
        }

        return answer;
    }
}
