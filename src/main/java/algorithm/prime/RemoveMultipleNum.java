package algorithm.prime;

import java.util.ArrayList;
import java.util.List;

public class RemoveMultipleNum {
    //에라토스테네스의 체

    //50미만의 모든 소수를 구하는 알고리즘
    public int removePrime(int n) {
        int num = 0;
        List<Integer> list = new ArrayList<>();
        int cnt = 2;
        int j = 0;
        boolean tf = true;

        for(int i=2; i<=n; i++) {
            list.add(i);
        }

        return num;
    }
}
