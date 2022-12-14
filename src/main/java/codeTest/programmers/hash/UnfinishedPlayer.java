package codeTest.programmers.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnfinishedPlayer {
    //완주하지 못한 선수

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hashMap = new HashMap<>();

        for(String x : participant) {
            hashMap.put(x, hashMap.getOrDefault(x,0)+1);
        }

        for(String x : completion) {
            hashMap.put(x,hashMap.get(x)-1);
        }

        for(Map.Entry<String,Integer> e : hashMap.entrySet()) {
            if(e.getValue() == 1) {
                answer = e.getKey();
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        UnfinishedPlayer unfinishedPlayer = new UnfinishedPlayer();

        String[]  t1a = {"mislav", "stanko", "mislav", "ana"};
        String[] t1b = {"stanko", "ana", "mislav"};

        String[]  t2a = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] t2b = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(unfinishedPlayer.solution(t1a,t1b));
        System.out.println(unfinishedPlayer.solution(t2a,t2b));
    }
}
