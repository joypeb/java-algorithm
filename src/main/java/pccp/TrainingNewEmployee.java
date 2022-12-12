package pccp;

import java.util.PriorityQueue;

public class TrainingNewEmployee {
    //pccp 모의고사 2회 신입사원 교육

    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<ability.length; i++) {
            pq.add(ability[i]);
        }

        for(int i=0; i<number; i++) {
            int num = pq.poll() + pq.poll();
            pq.add(num);
            pq.add(num);
        }

        answer = pq.stream().reduce(0, Integer::sum);
        return answer;
    }
}
