package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp_2081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int cnt = 0;
        int max = 0;

        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<9; i++) {
            if(max < arr[i]) {
                max = arr[i];
                cnt = i;
            }
        }

        System.out.println(max + "\n" + (cnt+1));
    }
}
