package inflearn.java_algorithm;

import java.util.Scanner;
import java.util.Stack;

public class ParenRemove5_2 {
    public String solution(String str) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();

        for(char x : arr) {
            if(x == '(') {
                stack.push(x);
            } else if(x == ')') {
                stack.pop();
            } else{
                if (stack.empty()) {
                    result += x;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParenRemove5_2 parenRemove5_2 = new ParenRemove5_2();

        String str = sc.nextLine();

        System.out.println(parenRemove5_2.solution(str));
    }
}
