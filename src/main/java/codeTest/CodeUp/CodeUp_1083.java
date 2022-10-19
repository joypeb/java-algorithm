package CodeUp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeUp_1083 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=num; i++) {
            if(i==3 || i==6 || i==9) {
                System.out.printf("X ");
            } else{
                System.out.printf("%d ",i);
            }
        }
    }
}
