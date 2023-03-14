package inflearn.java_algorithm;

import java.util.Scanner;

public class Inf6_6Imp {
    //장난꾸러기

    //철수를 번저 찾고 그 다음 친구를 찾는다
    static void solution(int[] arr) {
        int chul = 1, friend = 2;
        int friendPreNum = 0;

        for(int i=arr.length-1; i>=1; i--) {
            if(arr[i] < arr[i-1]) {
                friend = i+1;
                break;
            }
        }

        for(int i=0; i<friend-1; i++) {
            if(arr[i] >= arr[friend-2]) {
                chul = i+1;
                break;
            }
        }

        System.out.println(chul + " " + friend);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }
}
