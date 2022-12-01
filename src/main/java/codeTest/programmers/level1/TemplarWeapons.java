package codeTest.programmers.level1;

public class TemplarWeapons {
    //기사단원의 무기

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            int count = divisorCount(i);
            if(count > limit) count = power;
            answer += count;
        }

        return answer;
    }

    public static int divisorCount(int num)
    {
        int count = 0;
        for(int i=1; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                if (num / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
