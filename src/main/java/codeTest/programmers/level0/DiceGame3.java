package codeTest.programmers.level0;

import java.util.*;
import java.util.stream.Collectors;

public class DiceGame3 {

    /*
    *   네 주사위에서 나온 숫자가 모두 같다면 1111 x p
    *   세 주사위에서 나온 숫자가 같고 나머지 다른 주시위에서 나온 숫자가 다르다면 (10 * p + q)^2
    *   주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
    *   어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
    *   네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
    *
    *   4개가 같을때
    *   3개가 같을때
    *   2개가 같은게 2번일때
    *   2개가 같을때
    * */
    public static void main(String[] args) {
        DiceGame3 diceGame3 = new DiceGame3();


        System.out.println(diceGame3.solution(6,6,6,6));
    }

    public int solution(int a, int b, int c, int d) {
        int answer = 0;

        int[] counts = new int[7];

        counts[a]++;
        counts[b]++;
        counts[c]++;
        counts[d]++;

        for(int i=1; i<counts.length; i++) {
            if(counts[i] == 4)
                return 1111 * i;
            else if(counts[i] == 3) {
                for(int j=1; j<counts.length; j++) {
                    if(counts[j] == 1) return (int)Math.pow((10 * i + j),2);
                }
            } else if(counts[i] == 2) {
                if(Arrays.stream(counts).anyMatch(val -> val == 1)) {
                    int num = 1;
                    for(int j=1; j<counts.length; j++) {
                        if(counts[j] == 1) num*=j;
                    }
                    return num;
                } else {
                    for(int j=i+1; j<counts.length; j++) {
                        if(counts[j] == 2) return (i+j) * Math.abs(i-j);
                    }
                }
            } else {
                int cnt = (int) Arrays.stream(counts).filter(val -> val == 1).count();
                if(cnt == 4) {
                    for(int j=1; j<counts.length; j++) {
                        if(counts[j] == 1) return j;
                    }
                }
            }

        }

        return answer;
    }
}
