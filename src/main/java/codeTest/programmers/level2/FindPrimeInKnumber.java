package codeTest.programmers.level2;

public class FindPrimeInKnumber {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n,k);
        String[] nums = num.split("0");

        for(int i=0; i<nums.length; i++) {
            if(!nums[i].equals("") && prime(Long.parseLong(nums[i]))) answer++;
        }
        return answer;
    }

    public boolean prime(long num) {
        if(num == 1) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}
