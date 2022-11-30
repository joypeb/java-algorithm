package codeTest.programmers.level1;

import java.util.Stack;

public class PnY {
    //p와 y의 개수
    boolean solution(String s) {
        char[] s2 = s.toLowerCase().toCharArray();
        int cnt = 0;

        for(int i=0; i<s2.length; i++) {
            if(s2[i] == 'p') cnt++;
            else if (s2[i] == 'y') cnt--;
        }

        if(cnt == 0) {
            return true;
        } else {
            return false;
        }
    }
}
