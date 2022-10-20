package codeTest.programmers.level2;

public class RepeatBinary {
    //이진 변환 반복하기

    public int[] solution(String s) {
        int cnt = 0;
        int zero = 0;
        String x = "";

        while(true) {
            x = s.replaceAll("0","");
            int l = x.length();
            zero += s.length() - l;
            String bi = Integer.toBinaryString(l);
            cnt++;
            s = bi;
            if(s.length() == 1) {
                break;
            }
        }

        int[] answer = {cnt,zero};
        return answer;
    }

    public static void main(String[] args) {

    }
}
