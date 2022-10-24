package codeTest.programmers.sort;

import java.util.Arrays;

public class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);

            answer[i] = arr[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Knumber knumber = new Knumber();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(knumber.solution(array,commands)));

    }
}
