package algorithm.recursion;

public class RecursionArr {

    public static int solution(int[] arr, int cnt) {
        if(arr.length == cnt){
            return 0;
        }

        return arr[cnt] + solution(arr,cnt+1);
    }

    public static void main(String[] args) {
        int[] arr = {7,3,2,9};

        System.out.println(solution(arr,0));
    }
}
