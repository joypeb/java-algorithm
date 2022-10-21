package algorithm.stack;

public class Stack03Bracket {

    public boolean solution(String s){
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

    public static void main(String[] args) {
        Stack03Bracket st = new Stack03Bracket();

        boolean t = st.solution("()()()()()");
        System.out.println(t);
    }
}
