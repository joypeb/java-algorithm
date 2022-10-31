package codeTest.programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class MockExam {
    public int[] solution(int[] answers) {

        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for(int i=0; i< supo3.length; i++) {
            if(i< supo1.length) {
                if(supo1[i] == answers[i]) {
                    cnt1++;
                }
            }

            if(i< supo2.length) {
                if(supo2[i] == answers[i]) {
                    cnt2++;
                }
            }

            if(supo3[i] == answers[i]) {
                cnt3++;
            }
        }



        return answer;
    }
}
