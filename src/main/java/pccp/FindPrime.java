package pccp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class FindPrime {
    //소수 찾기

    //모든 조합의 숫자를 만든다
    //소수의 개수를 센다
    //소수의 개수를 반환한다
    HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        //숫자를 배열로 나눈다
        char[] arr = numbers.toCharArray();

        recursive("",numbers);

        Iterator<Integer> it = numberSet.iterator();

        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number))
                answer++;
        }

        return answer;
    }

    public void recursive(String comb, String others) {
        //1. 현재 조합을 set에 추가한다
        if (!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
        //2. 남은 숫자중 하나는 더 더해서 새로운 조합을 만든다
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num%i == 0 ) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();

        System.out.println(findPrime.solution("17"));
    }
}
