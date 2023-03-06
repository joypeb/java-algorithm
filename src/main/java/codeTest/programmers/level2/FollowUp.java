package codeTest.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class FollowUp {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();

        set.add(words[0]);
        stack.add(words[0]);

        for(int i=1; i<words.length; i++) {
            String lastWord = stack.peek();
            if(set.contains(words[i]) || lastWord.charAt(lastWord.length()-1) != words[i].charAt(0)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }

            set.add(words[i]);
            stack.push(words[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        FollowUp followUp = new FollowUp();

        String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] result = followUp.solution(3,arr);

        System.out.println(Arrays.toString(result));
    }
}
