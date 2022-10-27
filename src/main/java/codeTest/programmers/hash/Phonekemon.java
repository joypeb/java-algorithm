package codeTest.programmers.hash;

import java.util.HashMap;

public class Phonekemon {
    //폰켓몬

    public int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int x : nums) {
            hm.put(x,0);
        }

        int numsDivide = nums.length/2;
        int hmSize = hm.size();

        if(hmSize >= numsDivide) {
            answer = numsDivide;
        } else {
            answer = hmSize;
        }


        return answer;
    }

    public static void main(String[] args) {
        Phonekemon phonekemon = new Phonekemon();

        int[] t1 = {3,3,3,2,2,4};
        int[] t2 = {3,3,3,2,2,2};

        System.out.println(phonekemon.solution(t1));
        System.out.println(phonekemon.solution(t2));
    }
}
