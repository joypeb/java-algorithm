package CodeUp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeUp_1079 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean tf = true;

        while(tf) {
            char c = (char)br.read();
            if(c == ' ') {
                continue;
            }
            System.out.println(c);
            if((int)c == 113) {
                break;
            }
        }
    }
}
