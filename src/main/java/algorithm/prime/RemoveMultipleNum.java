package algorithm.prime;

import java.util.ArrayList;
import java.util.List;

public class RemoveMultipleNum {
    //에라토스테네스의 체

    //50미만의 모든 소수를 구하는 알고리즘
    public int removePrime(int n) {
        int num = 0;
        int[] arr = new int[n+1];

        for(int i=2; i<=n; i++) {
            arr[i] = i;
        }

        for(int i=2; i<=n; i++) {
            //arr[i]안의 값이 0이면 건너뛰기
            if(arr[i] == 0) continue;

            //n이 되기전까지 2배씩 증가
            //자기 자신은 건너뛴다
            for(int j=2*i; j<=n; j+=i) {
                arr[j] = 0;
            }

        }

        for(int i=0; i< arr.length; i++) {
            if(arr[i] != 0) {
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        RemoveMultipleNum removeMultipleNum = new RemoveMultipleNum();

        System.out.println(removeMultipleNum.removePrime(100));

    }
}
