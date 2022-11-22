package pccp;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            char first = arr[i].charAt(0);
            if(48 <= first && first <= 57) {
                arr[i] = arr[i].toLowerCase();
            } else {
                String words = arr[i].substring(1).toLowerCase();
                if(97 <= first && first <= 122) {
                    first-=32;
                }

                arr[i] = first + words;
            }
        }

        for(String x : arr) {
            answer += x + " ";
        }

        return answer.trim();
    }

    public static void main(String[] args) {

    }
}
