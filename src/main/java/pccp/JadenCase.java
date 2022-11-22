package pccp;

public class JadenCase {
    public String solution(String s) {
        String[] arr = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        if(!(48 <= arr[0].charAt(0) && arr[0].charAt(0) <= 57)) {
            char first = (char)(arr[0].charAt(0) - 32);
        }

        for(int i=0; i<arr.length; i++) {
            char first = 0;

            if(!(48 <= arr[i].charAt(0) && arr[i].charAt(0) <= 57)) {
                first = (char)(arr[i].charAt(0) - 32);
            } else {
                first = arr[i].charAt(0);
            }

            sb.append(first);
            sb.append(arr[i].substring(1));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();

        String s = "3people unFollowed me";

        System.out.println(jadenCase.solution(s));
    }
}
