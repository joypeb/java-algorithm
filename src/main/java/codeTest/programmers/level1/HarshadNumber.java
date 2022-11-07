package codeTest.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class HarshadNumber {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int or = x;

        while(x != 0) {
            sum += x % 10;
            x/=10;
        }
        if(or%sum == 0) {
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        HarshadNumber harshadNumber = new HarshadNumber();

        System.out.println(harshadNumber.solution(10));
    }
}
