package CodeUp;

import java.util.Scanner;

public class CodeUp_1620 {
    public static int solution(int num) {
        int answer = 0;
        while(num > 0) {
            answer += num%10;
            num/=10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = num;

        while(num > 9) {
            result = solution(num);
            num = result;
        }
        System.out.println(result);
    }
}
