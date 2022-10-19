package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String o = br.readLine();
        int octal = Integer.parseInt(o,8);
        System.out.printf("%d",octal);
    }
}
