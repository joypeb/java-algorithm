package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_1035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String o = br.readLine();
        int hex = Integer.parseInt(o,16);
        System.out.printf("%o",hex);
    }
}
