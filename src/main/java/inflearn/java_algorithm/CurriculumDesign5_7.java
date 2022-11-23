package inflearn.java_algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CurriculumDesign5_7 {
    //교육과정 설계

    public String sol(String s, String in) {

        Queue<Character> q = new LinkedList<>();
        char[] sArr = s.toCharArray();
        char[] inArr = in.toCharArray();

        for(char x : sArr) {
            q.offer(x);
        }

        for(int i=0; i< inArr.length; i++) {
            if(q.peek() == inArr[i]) {
                q.poll();
            }

            if(q.isEmpty()) return "YES";
        }

        if(q.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        CurriculumDesign5_7 main = new CurriculumDesign5_7();
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String in = sc.nextLine();

        System.out.println(main.sol(s,in));
    }
}
