package inflearn.java_algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class KLargestNumber4_5 {
    public int solution(int[] arr, int k) {
        int result = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();

        int c1,c2,c3;
        int largeNum = 0;

        for(c1=0; c1< arr.length-2; c1++) {
            for(c2=c1+1; c2< arr.length-1; c2++) {
                for(c3=c2+1; c3< arr.length; c3++) {
                    treeSet.add(arr[c1]+arr[c2]+arr[c3]);
                }
            }
        }


        if(treeSet.size() < k) {
            return -1;
        } else{
            largeNum = treeSet.last();
            for(int i=0; i<k-1; i++) {
                largeNum = treeSet.lower(largeNum);
            }
        }

        return largeNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KLargestNumber4_5 main = new KLargestNumber4_5();

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(arr,k));
    }
}
