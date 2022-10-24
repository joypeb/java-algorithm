package codeTest.programmers.sort;

import java.util.*;

public class MostBigNumber {
    //가장 큰 수

    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for(int i=0; i< numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arr[0].equals("0")) {
            return "0";
        }

        for(String x : arr) {
            answer += x;
        }

        return answer;
    }

    public static void main(String[] args) {
        MostBigNumber mostBigNumber = new MostBigNumber();
        System.out.println(mostBigNumber.solution(new int[]{2, 1,3,1,5}));
    }
}
