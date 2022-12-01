package codeTest.programmers.pccp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportsDay {
    static int[] output;
    static int result = 0;

    public int solution(int[][] ability) {
        int answer = 0;

        //배열의 길이
        int n = ability[0].length;

        //뽑고자 하는 배열
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        //출력 결과를 저장하는 배열
        output = new int[n];

        //방문 여부 체크
        boolean[] visited = new boolean[n];

        perm(arr,visited,0,n,n,ability);
        System.out.println(result);
        return answer;
    }

    public static void perm(int[] arr, boolean[] visited, int depth, int n, int r, int[][] ability) {
        if(depth == r) {
            int sum = 0;
            for(int i=0; i< output.length; i++) {
                int[] select = new int[ability.length];
                for (int j = 0; j < ability.length; j++) {
                    select[j] = ability[j][i];
                }
                Arrays.sort(select);
                sum += select[select.length-output[i]];
            }
            if(sum > result) result = sum;
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr,visited,depth+1,n,r,ability);
                visited[i]=false;
            }
        }
    }



    public static void main(String[] args) {
        SportsDay sportsDay = new SportsDay();

        int[][] arr = {{40, 10, 10}, {20, 5, 0,}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int[][] arr2 = {{20,30},{30,20},{20,30}};
        sportsDay.solution(arr2);
    }
}
