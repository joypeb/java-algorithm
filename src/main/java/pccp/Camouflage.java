package pccp;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    //위장

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            System.out.println(clothes[i][1]);
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1],0)+1);
        }

        for(Map.Entry<String,Integer> entry : hashMap.entrySet()) {
            answer *= (1+entry.getValue());
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();

        String[][] arr = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};

        System.out.println(camouflage.solution(arr));
    }
}
