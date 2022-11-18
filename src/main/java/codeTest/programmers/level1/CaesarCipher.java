package codeTest.programmers.level1;

public class CaesarCipher {
    //시저 암호

    public String solution(String s, int n) {
        String answer = "";

        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++) {
            if(65 <= arr[i] && arr[i] <= 90) {
                if(arr[i]+n > 90) {
                    arr[i] = (char) (arr[i] + n - 26);
                } else{
                    arr[i] += n;
                }
            } else if(arr[i] == 32){

            } else {
                if(arr[i]+n > 122) {
                    arr[i] = (char) (arr[i] + n - 26);
                } else{
                    arr[i] += n;
                }
            }

            answer += arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();

        String test = "AB";
        String test2 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(caesarCipher.solution(test2, 1));
    }
}
