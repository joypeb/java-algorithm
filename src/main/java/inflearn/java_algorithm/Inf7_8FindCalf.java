package inflearn.java_algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inf7_8FindCalf {
    //송아지 찾기 bfs
    static int bfs(int h, int c) {
        int[] arr = {1,-1,5};
        HashSet<Integer> check = new HashSet<>(); //한번 넣은 수는 안넣게 하는 체크 배열

        Queue<Integer> q = new LinkedList<>();
        q.offer(h);
        int l = 0;

        while (!q.isEmpty()) {
            int length = q.size();
            for(int i=0; i<length; i++) {
                int num = q.poll();
                if(c == num) return l;
                for(int x : arr) {
                    int nx = num + x;
                    if(nx >= 1 && nx <= 10000 &&  !check.contains(nx)) {
                        check.add(nx);
                        q.offer(nx);
                    }
                }
            }
            l++;
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int human = sc.nextInt();
        int calf = sc.nextInt();

        System.out.println(bfs(human,calf));
    }
}
