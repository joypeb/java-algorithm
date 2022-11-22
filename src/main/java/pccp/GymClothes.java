package pccp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GymClothes {
    //체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int dup = 0;

        HashSet<Integer> hashSetReserve = new HashSet<>();

        for(int x : reserve) {
            hashSetReserve.add(x);
        }

        for(int x : lost) {
            if(hashSetReserve.contains(x)) dup++;
        }

        int angel = lost.length - reserve.length;
        if(angel < 0) angel = 0;

        answer = n - angel;

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

        int n3 = 5;
        int[] lost3 = {2, 4};
        int[] reserve3 = {3};

        int n4 = 5;
        int[] lost4 = {2, 4};
        int[] reserve4 = {4};

        System.out.println(gymClothes.solution(n,lost,reserve));
        System.out.println(gymClothes.solution(n2,lost2,reserve2));
        System.out.println(gymClothes.solution(n3,lost3,reserve3));
        System.out.println(gymClothes.solution(n4,lost4,reserve4));
    }
}
