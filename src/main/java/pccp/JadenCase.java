package pccp;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toLowerCase().toCharArray();

        if(!(48 <= arr[0] && arr[0] <= 57)) {
            arr[0] -= 32;
        }

        answer += arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] == 32 && !(48 <= arr[i] && arr[i] <= 57)) {
                arr[i] -= 32;
            }
            answer+=arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();

        String s = "3people unFollowed me";

        System.out.println(jadenCase.solution(s));
    }
}
