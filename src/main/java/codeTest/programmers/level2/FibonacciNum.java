package codeTest.programmers.level2;

public class FibonacciNum {
    //피보나치 수
    public int solution(int n) {
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n; i++) {
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        int answer = (int)arr[n];
        return answer;
    }
}
