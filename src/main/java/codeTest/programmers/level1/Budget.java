package codeTest.programmers.level1;

public class Budget {
    //예산
    public int solution(int[] d, int budget) {
        int answer = 0;

        //최대로 부서에게 지원해 주려면 제일 낮은 금액을 신청한 부서들을 먼저 확인해야한다

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
