package pccp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i< prices.length-1; i++) {
            int cnt = 1;
            inner:for(int j=i+1; j< prices.length-1; j++) {
               if(prices[i] > prices[j]) {
                   break inner;
               } else {
                   cnt++;
               }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

        int[] prices = {1,2,3,2,3};

        int[] result = stockPrice.solution(prices);

        System.out.println(Arrays.toString(result));
    }
}
