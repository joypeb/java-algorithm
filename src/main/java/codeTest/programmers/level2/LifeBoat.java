package codeTest.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LifeBoat {

    public int solution(int[] people, int limit) {
        int answer = 0;
        int half = limit/2;

        //사람이 한명일 경우
        if(people.length == 1)
            return 1;

        //오름차순 정렬
        Arrays.sort(people);

        //사람의 최소 무게가 무게제한의 절반을 넘길경우 -> 무조건 한사람씩만 탈 수 있음
        if(half < people[0])
            return people.length;

        //한 배에 최대 2명까지 가능 안될경우 다음 사람으로 이동
        int lt = 0, rt = people.length-1;

        for(int i=people.length-1; i>=0; i--) {
            if(i < lt) break;

            if(people[i] + people[lt] <= limit) {
                answer++;
                lt++;
                rt--;
            } else {
                answer++;
                rt--;
            }
        }

        return answer ;
    }

    public static void main(String[] args) {
        LifeBoat lifeBoat = new LifeBoat();

        int[] people = {50,50,50,50,50,60,60};
        int limit = 100;

        int result = lifeBoat.solution(people,limit);

        System.out.println(result);
    }
}
