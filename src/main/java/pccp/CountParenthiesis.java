package pccp;

public class CountParenthiesis {
    //올바른 괄호의 개수 검사

    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        char[] arr = s.toCharArray();

        if(arr[0] == ')') {
            return false;
        }

        for(int x: arr) {
            if(x == '(') {
                cnt++;
            } else if(x == ')') {
                cnt--;
            }

            if(cnt < 0) {
                break;
            }
        }

        if(cnt == 0) {
            return answer;
        } else {
            return false;
        }
    }
}
