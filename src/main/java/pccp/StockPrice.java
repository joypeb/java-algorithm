package pccp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> q = new LinkedList<>();
        q.offer(prices[0]);
        int answerTracker = 0;

        for(int i=1; i<prices.length; i++) {
            q.offer(prices[i]);

            if(prices[i-1] > prices[i]) {
               for(int j=answerTracker; j<i-1; j++) {
                   answer[j] = q.size();
                   q.poll();
               }
               answer[i-1] = 1;
               q.poll();
               answerTracker = i;
            }
        }

        for(int i=answerTracker; i< prices.length-1; i++) {
            answer[i] = q.size();
            q.poll();
        }
        answer[prices.length-2] = 1;
        answer[prices.length-1] = 0;

        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

        int[] prices = {1,2,3,2,3};

        int[] result = stockPrice.solution(prices);

        System.out.println(Arrays.toString(result));
    }
}
