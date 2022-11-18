package codeTest.programmers.pccp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneticLaw {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        String[] genSt = {"","RR","Rr","rr"};
        //RR = 1, Rr = 2, rr= 3;
        //RR -> 1 1 1 1
        //Rr -> 1 2 2 3
        //rr -> 3 3 3 3

        List<Integer> list = new ArrayList<>();

        list.add(2);
        int gen = 0;

        for(int i=0; i<queries.length; i++) {
            if(gen < queries[i][0]) {
                gen = queries[i][0];
            }
        }

        System.out.println("gen = " +gen);
        for(int i=0; i<gen; i++) {
            for(int j=0; j<list.size(); j++) {
                if(list.get(i) == 1) {
                    list.add(1);
                    list.add(1);
                    list.add(1);
                    list.add(1);
                } else if(list.get(i) == 2) {
                    list.add(1);
                    list.add(2);
                    list.add(2);
                    list.add(3);
                } else if(list.get(i) == 3){
                    list.add(3);
                    list.add(3);
                    list.add(3);
                    list.add(3);
                }
            }
        }

        for(int x : list) {
            System.out.println(x);
        }

        for(int i=0; i<queries.length; i++) {
            int num = queries[i][0];
            int cnt = 0;

            for(int j=num; j>=0; j--) {
                cnt+=Math.sqrt(j);
            }

            answer[i] = genSt[list.get(cnt+queries[i][1])];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{3,5}};

        GeneticLaw geneticLaw = new GeneticLaw();

        String[] result = geneticLaw.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
