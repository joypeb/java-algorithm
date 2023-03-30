package codeTest.programmers.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tuple {
    /*
    * 문자열에서 나오는 숫자가 많을수록 answer배열의 앞에 위치한다
    * 1. 숫자만 뽑아와야되기 때문에 {, }를 없애준다
    * 2. ,를 기준으로 배열로 만든다
    * 3. hashMap을 만들어 그 안에 숫자들의 개수들을 기록한다
    * 4. hashMap을 value기준으로 정렬한다
    * 5. hashMap size와 똑같이 answer를 만들고 hashMap은 오름차순 정렬이기때문에 반대로 answer는 내림차순으로 넣어준다
    * */
    public int[] solution(String s) {
        int[] answer = {};

        HashMap<Integer,Integer> hash = new HashMap<>();

        s = s.replaceAll("\\{","").replaceAll("\\}","");
        String[] sArr = s.split(",");

        for(int i=0; i<sArr.length; i++) {
            int num = Integer.parseInt(sArr[i]);
            hash.put(num,hash.getOrDefault(num,0)+1);
        }

        answer = new int[hash.size()];
        int cnt = hash.size()-1;

        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(hash.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for(Map.Entry<Integer,Integer> entry : list) {
            answer[cnt] = entry.getKey();
            cnt--;
        }

        return answer;
    }
}
