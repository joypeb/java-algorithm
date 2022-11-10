package codeTest.programmers.level2;

import java.util.*;

public class FunctionDevelopment {
    //기능 개발
    public int[] solution(int[] progresses, int[] speeds) {
        int[] proDay = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            double num = 100 - progresses[i];
            proDay[i] = (int)Math.ceil(num/speeds[i]);
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        int max = proDay[0];
        int cnt = 1;

        for(int i=1; i< proDay.length; i++) {
            if(max >= proDay[i]) {
                cnt = stack.pop()+1;
                stack.push(cnt);
            } else{
                stack.push(1);
                max = proDay[i];
            }
        }

        int[] answer = new int[stack.size()];

        for(int i=stack.size()-1; i>=0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] pro = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};

        FunctionDevelopment functionDevelopment = new FunctionDevelopment();

        int[] result = functionDevelopment.solution(pro,speeds);
        System.out.println(Arrays.toString(result));
    }
}
