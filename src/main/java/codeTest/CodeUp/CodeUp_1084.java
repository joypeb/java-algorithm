package CodeUp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeUp_1084 {
    //자바로는 풀이 불가하므로 c로 해결
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] arr = s.split(" ");
        int cnt = 0;

        for(int i=0; i<Integer.parseInt(arr[0]); i++) {
            for(int j=0; j<Integer.parseInt(arr[1]); j++) {
                for(int k=0; k<Integer.parseInt(arr[2]); k++) {
                    System.out.printf("%d %d %d\n",i,j,k);
                    cnt++;
                }
            }
        }
        System.out.printf("%d",cnt);
    }
}
