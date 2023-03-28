package codeTest.programmers.level2;

import java.util.*;

public class ChooseTangerine {
    public int solution(int k, int[] tangerine) {
        /*
        크기별 귤의 개수들을 모아놓은 배열을 만든다
        배열을 정렬한다
        위에서부터 계산해서 k랑 같거나 클때까지 카운트
        */

        int answer = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i:tangerine) {
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }

        List<Integer> list = new LinkedList<>(hashMap.values());
        list.sort(Collections.reverseOrder());

        for(int x : list) {
            k -= x;
            answer++;

            if(k <= 0) break;
        }

        return answer;
    }
}
