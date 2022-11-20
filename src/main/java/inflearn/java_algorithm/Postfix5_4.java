package inflearn.java_algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Postfix5_4 {
    public int solution(String str) {
        int result = 0;
        Stack<Integer> st = new Stack<>();
        char[] arr = str.toCharArray();

        st.push(arr[0]-48);
        st.push(arr[1]-48);

        for(int i=2; i<arr.length; i++) {
            if(49 <= arr[i] && arr[i] <= 57) {
                st.push(arr[i]-48);
            } else {
                int num1 = st.pop();
                int num2 = st.pop();
                int num3 = 0;
                switch (arr[i]) {
                    case '+':
                        num3 = num1+num2;
                        st.push(num3);
                        break;
                    case '-' :
                        num3 = num2-num1;
                        st.push(num3);
                        break;
                    case '*':
                        num3 = num1*num2;
                        st.push(num3);
                        break;
                    case '/' :
                        num3 = num2/num1;
                        st.push(num3);
                        break;
                }
            }
        }

        result = st.pop();
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Postfix5_4 main = new Postfix5_4();

        System.out.println(main.solution(str));
    }
}
