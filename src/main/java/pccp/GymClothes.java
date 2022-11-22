package pccp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GymClothes {
    //체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        if(lost.length <= reserve.length) {
            return n;
        } else {
            answer = n - (lost.length - reserve.length);
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
