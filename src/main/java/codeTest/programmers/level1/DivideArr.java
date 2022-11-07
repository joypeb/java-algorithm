package codeTest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArr {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor == 0) {
                list.add(arr[i]);
            }
        }

        if(list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];
            for (int i=0; i<answer.length; i++) {
                answer[i] = list.get(i);
            }

            Arrays.sort(answer);
        }
        return answer;
    }
}
