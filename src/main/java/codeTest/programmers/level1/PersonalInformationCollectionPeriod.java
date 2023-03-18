package codeTest.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonalInformationCollectionPeriod {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        String[] todayDate = today.split("\\.");
        int todayInt = (Integer.parseInt(todayDate[0])*10000) + (Integer.parseInt(todayDate[1])*100) + Integer.parseInt(todayDate[2]);


        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            hashMap.put(term[0], Integer.parseInt(term[1]));
        }

        for(int i=0; i<privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            String[] date = pri[0].split("\\.");
            int[] dateInt = new int[3];

            for(int j=0; j<date.length; j++) {
                dateInt[j] = Integer.parseInt(date[j]);
            }

            if(hashMap.get(pri[1]) < 12) {
                dateInt[1] += hashMap.get(pri[1]);
            } else {
                dateInt[0] += hashMap.get(pri[1])/12;
                dateInt[1] += hashMap.get(pri[1])%12;
            }

            if(dateInt[1] > 12) {
                dateInt[0] += 1;
                dateInt[1] -= 12;
            }

            if(dateInt[2] == 1) {
                dateInt[2] = 28;
                dateInt[1] -= 1;
            } else {
                dateInt[2] -= 1;
            }

            int resultDateInt = (dateInt[0]*10000) + (dateInt[1]*100) + dateInt[2];

            System.out.println(resultDateInt);

            if((todayInt - resultDateInt) > 0) {
                list.add(i+1);
            }
        }

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
