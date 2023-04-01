package codeTest.programmers.level2;

import java.util.*;

public class Compression {
    /*
    모든 알파벳을 1부터 27까지 저장
    그 다음부터는 한글자씩 for문을 돈다
    한 글자 안에서 한 글자가 있을경우와 없을경우를 찾는다
    한 글자가 있을경우 다음 글자를 합친 경우도 있는지 찾고 없을경우 합친 글자를 등록한다
    합친 글자가 있을경우 또 그 다음 글자를 합친 경우가 있는지 찾고 없을경우 합친 글자를 등록한다

    없을경우 바로 등록한다

    */
    public int[] solution(String msg) {
        int[] answer = {};
        int cnt = 27;
        HashMap<String, Integer> hash = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=65; i<91; i++) {
            hash.put(""+(char)i, i-64);
        }

        for(int i=0; i<msg.length(); i++) {
            String w = ""+msg.charAt(i);
            int cNum = i+1;

            inner:while(cNum < msg.length()) {
                if(hash.get(w+msg.charAt(cNum)) != null) {
                    w = w+msg.charAt(cNum);
                    cNum++;
                } else {
                    hash.put(w+msg.charAt(cNum),cnt);
                    cnt++;
                    break inner;
                }
            }
            list.add(hash.get(w));
            i = cNum-1;
        }

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
