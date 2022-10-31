package codeTest.programmers.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
    public int[] solution(int[] answers) {

        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = {0,0,0};

        for(int i=0; i<answers.length; i++) {
            if(supo1[i%supo1.length] == answers[i]) {
                cnt[0]++;
            }
            if(supo2[i%supo2.length] == answers[i]) {
                cnt[1]++;
            }
            if(supo3[i%supo3.length] == answers[i]) {
                cnt[2]++;
            }
        }

        int max = Math.max(Math.max(cnt[0], cnt[1]),cnt[2]);

        ArrayList<Integer> maxList = new ArrayList<>();

        if(cnt[0] == max) maxList.add(1);
        if(cnt[1] == max) maxList.add(2);
        if(cnt[2] == max) maxList.add(3);


        int[] answer = new int[maxList.size()];

        for(int i =0; i<answer.length; i++) {
            answer[i] = maxList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        MockExam mockExam = new MockExam();

        int[] test = {1,2,3,4,5,1,2,3,4,5};

        int[] reulst = mockExam.solution(test);

        System.out.println(Arrays.toString(reulst));
    }
}
