package CodeUp;

import java.util.*;

public class CodeUp_1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split("\\.");

        //split을 할때 .으로 나누고싶으면 \\.을 쓰자

        System.out.printf("%04d.%02d.%02d",Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]));
    }
}
