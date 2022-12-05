package codeTest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinRectangle {
    //최소 직사각형
    //직사각형의 명함을 회전시켜 최대한 작은 지갑을 만들어라
    //1. 길이가 긴쪽과 작은쪽을 분류해야한다
    // 평균값을 구해 길이가 긴쪽과 작을 쪽을 분류한다
    // 길이가 긴쪽의 최대값, 길이가 작은쪽의 최대값을 찾는다
    // 둘이 곱한다

    public int solution(int[][] sizes) {
        int answer = 0;

        int[] w = new int[sizes.length];
        int[] h = new int[sizes.length];

        for(int i=0; i< sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                w[i] = sizes[i][1];
                h[i] = sizes[i][0];
            } else {
                w[i] = sizes[i][0];
                h[i] = sizes[i][1];
            }
        }

        Arrays.sort(w);
        Arrays.sort(h);

        answer = w[w.length-1] * h[h.length-1];

        return answer;
    }
}
