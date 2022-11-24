package pccp;

import java.util.Arrays;

public class RemoveMinNum {
    //제일 작은 수 제거하기
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];

        if(arr.length ==1 ) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == min) continue;
            answer[cnt++] = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        RemoveMinNum removeMinNum = new RemoveMinNum();

        int[] arr = {4,3,2,1,2};

        int[] result = removeMinNum.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
