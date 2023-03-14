package inflearn.java_algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Inf6_5CheckDup {
    //중복 확인

    //정렬을 이용해 해결
    public char solution(int[] arr) {
        Arrays.sort(arr);

        for(int i=1; i<arr.length; i++) {
            if(arr[i] == arr[i-1]) return 'D';
        }
        return 'U';
    }

    //해시를 이용해 해결
    public char solution2(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i : arr) {
            if(hashSet.contains(i)) return 'D';
            hashSet.add(i);
        }

        return 'U';
    }

    public static void main(String[] args) {
        Inf6_5CheckDup c = new Inf6_5CheckDup();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(c.solution(arr));
        System.out.println(c.solution2(arr));

    }
}
