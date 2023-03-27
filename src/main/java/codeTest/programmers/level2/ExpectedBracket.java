package codeTest.programmers.level2;

public class ExpectedBracket {
    //예상 대진표
    /*
    * 대진표에서 무조건 b가 크다고 가정할것이기때문에 a가 더 클경우 두 수를 바꿔준다
    * 경기에서 이겨 한단계 올라갈수록 수는 n/2의 올림 형태로 줄어든다
    * 또한 서로 맞붙는 상대는 작은 수가 홀수이고 큰수와의 차이는 1이나게된다
    * 이를 이용해 b-a가 1이고 작은수 a가 홀수인경우 서로 붙기때문에 while문을 탈출한다
    * */

    public int solution(int n, int a, int b)
    {
        int answer = 0;

        if(a-b > 0) {
            int num = a;
            a = b;
            b = num;
        }

        while(true) {
            answer++;
            if(b-a == 1 && a%2 == 1) break;
            a = calc(a);
            b = calc(b);
        }

        return answer;
    }

    public int calc(int num) {
        return (int)(Math.ceil((double)num/2));
    }
}
