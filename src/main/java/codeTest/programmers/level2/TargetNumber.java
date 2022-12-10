package codeTest.programmers.level2;

public class TargetNumber {
    //타겟넘버
    int[] numbers;
    int target;
    int answer;

    void dfs(int index, int sum) {
        //탈출조건
        if(index == numbers.length) {
            if(sum==target) answer++;
            return;
        }

        //수행동작
        dfs(index+1, sum+numbers[index]);
        dfs(index+1,sum-numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0,0);

        return answer;
    }

}
