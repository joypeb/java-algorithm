package pccp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GymClothes {
    //체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        HashSet<Integer> hReserve = new HashSet<>();
        for(int x : reserve) {
            hReserve.add(x);
        }

        for(int i=0; i<lost.length; i++) {
            if(hReserve.contains(lost[i])) {
                hReserve.remove(lost[i]);
            }
            else if(hReserve.contains(lost[i]-1)) {
                hReserve.remove(lost[i]-1);
            } else if(hReserve.contains(lost[i]+1)) {
                hReserve.remove(lost[i]+1);
            } else {
                answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        GymClothes gymClothes = new GymClothes();

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1,3,5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {1,4,5};

        int n3 = 6;
        int[] lost3 = {2, 4};
        int[] reserve3 = {3};

        int n4 = 5;
        int[] lost4 = {1,3};
        int[] reserve4 = {2,4};

        System.out.println(gymClothes.solution(n,lost,reserve));
        System.out.println(gymClothes.solution(n2,lost2,reserve2));
        System.out.println(gymClothes.solution(n3,lost3,reserve3));
        System.out.println(gymClothes.solution(n4,lost4,reserve4));
    }
}
