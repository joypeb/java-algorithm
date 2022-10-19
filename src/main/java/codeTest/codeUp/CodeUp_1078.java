package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_1078 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=1; i<=num; i++) {
            if(i % 2 == 0) {
                result += i;
            }
        }

        System.out.println(result);
    }
}
