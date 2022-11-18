package inflearn.java_algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class SearchAllAnagram4_4 {
    public int solution(String s, String t) {
        HashMap<String,Integer> sHashMap = new HashMap<>();
        HashMap<String,Integer> tHashMap = new HashMap<>();

        String[] sarr = s.split("");
        String[] tarr = t.split("");

        int lt=0,rt=tarr.length-1,cnt=0;

        for(String x : tarr) {
            tHashMap.put(x,tHashMap.getOrDefault(x,0)+1);
        }

        for(int i=0; i< tarr.length-1; i++) {
            sHashMap.put(sarr[i],sHashMap.getOrDefault(sarr[i],0)+1);
        }

        for(int i = rt; i< sarr.length; i++) {
            sHashMap.put(sarr[i],sHashMap.getOrDefault(sarr[i],0)+1);
            if(tHashMap.equals(sHashMap)) {
                cnt++;
            }
            sHashMap.put(sarr[lt],sHashMap.get(sarr[lt])-1);
            if(sHashMap.get(sarr[lt]) == 0) {
                sHashMap.remove(sarr[lt]);
            }
            lt++;
        }


        return cnt;
    }

    public static void main(String[] args) {
        SearchAllAnagram4_4 search = new SearchAllAnagram4_4();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        int result = search.solution(s,t);

        System.out.println(result);
    }
}
