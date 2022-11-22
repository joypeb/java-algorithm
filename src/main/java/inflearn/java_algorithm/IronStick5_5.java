package inflearn.java_algorithm;

import java.util.Scanner;
import java.util.Stack;

public class IronStick5_5 {
    //쇠막대기

    public int sol(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<arr.length; i++ ){
            if(arr[i] == '(') stack.push(arr[i]);
            else {
                if(arr[i-1] == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        IronStick5_5 main = new IronStick5_5();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(main.sol(s));
    }
}
