package inflearn.java_algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Correct5_1 {

    public String solution(String str) {
        String result = "YES";
        Stack<String> stack = new Stack<>();
        String[] arr = str.split("");

        if(arr.length%2 != 0) return "NO";

        if(arr[0].equals(")")) return "NO";

        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("(")) {
                stack.push(arr[i]);
            } else {
                if(stack.empty()) return "NO";
                if(stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        if(!stack.empty()) return "NO";

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Correct5_1 correct5_1 = new Correct5_1();

        System.out.println(correct5_1.solution(str));
    }
}
