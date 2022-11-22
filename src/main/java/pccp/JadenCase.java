package pccp;

public class JadenCase {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();

        /*if(!(48 <= arr[0].charAt(0) && arr[0].charAt(0) <= 57)) {
            char first = (char)(arr[0].charAt(0) - 32);
        }

        for(int i=0; i<arr.length; i++) {
            char first = 0;

            if (arr[i].length() == 0) {
                sb.append(" ");
                continue;
            }

            if(!(48 <= arr[i].charAt(0) && arr[i].charAt(0) <= 57)) {
                first = (char)(arr[i].charAt(0) - 32);
            } else {
                first = arr[i].charAt(0);
            }

            sb.append(first);
            sb.append(arr[i].substring(1));
            if(!(i == arr.length-1)) {
                sb.append(" ");
            }
        }*/

        if(Character.isDigit(arr[0])) {
            sb.append(arr[0]);
        } else if(!Character.isDigit(arr[0])) {
            sb.append((char)(arr[0]-32));
        } else if(arr[0] == 32){
            sb.append(arr[0]);
        }

        for(int i=1; i<arr.length; i++) {
            if(arr[i] == 32) {
                sb.append(arr[i]);
                continue;
            }

            if(arr[i-1] == 32) {
                if (!Character.isDigit(arr[i])) {
                    sb.append((char) (arr[i] - 32));
                } else {
                    sb.append(arr[i]);
                }
            } else{
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();

        String s = " 3peOple unFollowed  me ";

        System.out.println(jadenCase.solution(s));
    }
}
