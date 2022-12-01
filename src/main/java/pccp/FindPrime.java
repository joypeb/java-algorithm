package pccp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class FindPrime {
    public int solution(String numbers) {
        int answer = 0;

        char[] arr = numbers.toCharArray();



        return answer;
    }

    static int[] per(int[] arr, boolean[] visited, int m, int n, int cnt) {
        if(cnt == m) {
            System.out.println(Arrays.toString(arr));
            return arr;
        }

        for(int i=1; i <= arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                per(arr,visited,m,n,cnt+1);
                visited[i] = false;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();

        System.out.println(findPrime.solution("017"));
    }
}
