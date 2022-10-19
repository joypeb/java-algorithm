package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_1087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        boolean check = true;
        int cnt = 1;
        int cnt2 = 2;
        while(check) {
            if(num <= cnt) {
                System.out.println(cnt);
                check = false;
            }
            cnt += cnt2;
            cnt2++;
        }
    }
}
