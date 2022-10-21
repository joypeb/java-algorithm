package algorithm.stack;

import java.util.Stack;

public class Stack04ManyBracket {
    public boolean solution(String s ){
        boolean solution = true;
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        char[] bracket2 = {']','}',')'};


        for(int i=0; i< bracket2.length; i++) {
            if(bracket2[i] == arr[i]) {
                return false;
            }
        }

        for(int i=0; i< arr.length; i++) {
           if(arr[i] == '[' || arr[i] == '(' || arr[i] == '{') {
               st.push(arr[i]);
           } else if (arr[i] == ']') {
               if(st.peek() == '(' || st.peek() == '{') {
                   return false;
               } else{
                   st.pop();
               }
           } else if (arr[i] == '}') {
               if(st.peek() == '[' || st.peek() == '(') {
                   return false;
               } else {
                   st.pop();
               }
           } else if (arr[i] == ')') {
               if(st.peek() == '[' || st.peek() == '{') {
                   return false;
               } else {
                   st.pop();
               }
           }
        }

        if(st.empty()) {
            return solution;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Stack04ManyBracket st = new Stack04ManyBracket();

        boolean s = st.solution("({{{}]}})");

        System.out.println(s);
    }
}
