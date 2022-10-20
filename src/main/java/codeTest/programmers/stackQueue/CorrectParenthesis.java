package codeTest.programmers.stackQueue;

public class CorrectParenthesis {
    //올바른 괄호
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            char[] arr = s.toCharArray();
            int cnt1 = 0;
            int cnt2 = 0;

            if(arr[0] == ')') {
                answer = false;
            } else {
                for(char x : arr) {
                    if(x == '(') {
                        cnt1++;
                    } else {
                        cnt2++;
                    }

                    if(cnt1 < cnt2) {
                        break;
                    }
                }

                if(cnt1 != cnt2) {
                    answer = false;
                }
            }

            return answer;
        }

    }
}
