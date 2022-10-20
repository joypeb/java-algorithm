package codeTest.programmers.level2;

import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {

        StringTokenizer st = new StringTokenizer(s, " ");
        for(int i=0; i<st.countTokens(); i++) {
            System.out.println(st.nextToken());
        }

        return "";
    }
}

public class JadenCase {

    public static void main(String[] args) {
        Solution so = new Solution();
        so.solution("hello hello ");
    }
}
