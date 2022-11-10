package codeTest.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {
    //기능 개발
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] proDay = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            double num = 100 - progresses[i];
            proDay[i] = (int)Math.ceil(num/speeds[i]);
        }

        int cnt = 0;
        int maxPro = proDay[0];
        list.add(1);

        for(int i=1; i< proDay.length; i++) {
            if(proDay[i] < maxPro) {
                list.set(cnt, list.get(cnt) + 1);
            } else {
                cnt++;
                list.add(1);
                maxPro = proDay[i];
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0; i< list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int i = 100;
        int j = 30;
        float k = 30;

        float jj = 70/k;

        System.out.println((int)Math.ceil(jj));
    }
}
