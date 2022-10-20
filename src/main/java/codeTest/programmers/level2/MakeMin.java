package codeTest.programmers.level2;

import java.util.Arrays;

public class MakeMin {
    //최솟값 만들기

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int c = B.length-1;

        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[c];
            c--;
        }

        return answer;
    }

    public static void main(String[] args) {
        MakeMin makeMin = new MakeMin();

        int[] A = {3, 5, 9};
        int[] B = {5, 1, 7};

        int answer = makeMin.solution(A,B);
        System.out.println(answer);
    }
}
