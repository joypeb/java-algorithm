package codeTest.programmers.level2;

public class ExpressNumber {
    //숫자의 표현
    public int solution(int n) {
        int answer = 1;
        int num = 1;
        int n2 = n*2;
        boolean tf = true;

        while(tf) {
            for(int i=num+1; i<=n/2+1; i++) {
                if(n2 == (i-num+1)*(num+i)) {
                    answer++;
                    break;
                } else if (n2 < (i-num+1)*(num+i)) {
                    break;
                }
            }
            if(num == n/2+1) {
                tf = false;
            }
            num++;
        }

        return answer;
    }
}
