package codeTest.programmers.level2;

import java.util.Arrays;

public class MinAndMax {
    //최댓값과 최솟값
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] result = new int[arr.length];

        for(int i=0; i<result.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(result);

        String answer = result[0] + " " + result[result.length-1];
        return answer;
    }

    public static void main(String[] args) {

    }
}
