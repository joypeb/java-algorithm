package CodeUp;

import java.util.Scanner;

public class CodeUp_1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float f = sc.nextFloat();
        System.out.printf("%f",f);
        /*
            print : 직관적인 출력
            printf : 형식을 신경써서 출력
            그래서 위의 코드에 printf를 쓴 이유는 %f를 이용해 float을 출려하면
            float은 소수점6번째까지만 되고 형식에 신경쓰기때문에 소수점 6번째까지 다 나오게된다
         */
    }
}
