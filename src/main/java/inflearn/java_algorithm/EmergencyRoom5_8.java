package inflearn.java_algorithm;

import java.util.*;

public class EmergencyRoom5_8 {

    public int sol(Integer[] arr, int mNum) {
        Queue<Integer> danger = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();

        for(int i=0; i<arr.length; i++) {
            danger.offer(arr[i]);
            num.offer(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int cnt = 0;

        while(true) {
            if(arr[cnt] == danger.peek()) {
                if(mNum == num.peek()) {
                    cnt++;
                    break;
                }
                danger.poll();
                num.poll();
                cnt++;
            } else {
                danger.offer(danger.poll());
                num.offer(num.poll());
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        EmergencyRoom5_8 main = new EmergencyRoom5_8();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arr = new Integer[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.sol(arr,m));
    }
}
