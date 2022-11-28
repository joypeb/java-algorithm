package pccp;

public class MakeBigNun {
    public String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();

        while(k > 0) {
            int min = 57;
            int cnt = 0;
            for(int i=0; i<arr.length; i++ ) {
                if (arr[i] == 32) continue;
                else {
                    if (min > arr[i]) {
                        cnt = i;
                        min = arr[i];
                    }
                }
            }
            arr[cnt] = ' ';
            k--;
        }

        for(char x : arr) {
            if(x == ' ') continue;
            answer += x;
        }

        return answer;
    }

    public static void main(String[] args) {
        MakeBigNun makeBigNun = new MakeBigNun();

        String num = "1924";
        int k = 2;

        System.out.println(makeBigNun.solution("4177252841",4));
    }
}
