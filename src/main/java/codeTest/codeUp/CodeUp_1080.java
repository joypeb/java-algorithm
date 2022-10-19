package CodeUp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeUp_1080 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        boolean tf = true;
        int cnt = 1;
        int result = 0;

        while(tf) {
            result += cnt;
            if(result >= num) {
                System.out.println(cnt);
                tf=false;
            }
            cnt++;
        }
    }
}
