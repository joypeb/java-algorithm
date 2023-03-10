package codeTest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemovePairs {
    //짝지어 제거하기

    public int solution(String s) {
        int answer = 0;
        int index = 0, size = s.length();

        if(size % 2 == 1) return 0;

        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(index++));

        while (index < size) {
            char c = s.charAt(index++);

            if(stack.isEmpty()) stack.add(c);
            else if(stack.peek() == c) stack.pop();
            else stack.add(c);
        }

        if(stack.isEmpty()) answer = 1;

        return answer;
    }

    public static void main(String[] args) {
        RemovePairs removePairs = new RemovePairs();

        System.out.println(removePairs.solution("bbbbbbb"));
    }
}
