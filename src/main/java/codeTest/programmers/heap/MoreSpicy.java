package codeTest.programmers.heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    //더 맵게

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i< scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while(pq.size() >= 2 && pq.peek() < K) {
            pq.add(pq.poll() + (pq.poll()*2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();

        int[] arr = {1, 2, 3, 9, 10, 12};

        int result = moreSpicy.solution(arr,7);

        System.out.println(result);
    }
}
