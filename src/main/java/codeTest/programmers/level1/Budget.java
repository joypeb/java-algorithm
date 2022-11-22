package codeTest.programmers.level1;

import java.util.Arrays;

public class Budget {
    //예산
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        //최대로 부서에게 지원해 주려면 제일 낮은 금액을 신청한 부서들을 먼저 확인해야한다
        Arrays.sort(d);

        for(int x : d) {
            //합과 answer를 구하는 코드가 if문보다 앞에 와야한다
            //뒤에 둘경우 answer--가 먼저 실행되서 제대로 동작을 안할 수도 있어 테스트케이스3에서 오류가 난다
            sum+=x;
            answer++;
            if(sum == budget) {
                //같을 경우 최대예산이기때문에 그대로 answer리턴
                break;
            } else if(sum > budget) {
                //클경우 예산초과이기때문에 하나를 제거하고 리턴
                answer--;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4};
        int b = 9;

        int[] arr2 = {2,2,3,3};
        int b2 = 10;

        Budget budget = new Budget();

        System.out.println(budget.solution(arr,b));
        System.out.println(budget.solution(arr2,b2));

    }
}
