package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] solution(int[] arr) {
        //재귀 : 반복문 없이 해야될때
        int temp = 0;

        for(int i=1; i< arr.length; i++) {
            inner:for(int j=i; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else {
                    break inner;
                }
            }
        }

        return arr;
    }

    public int[] solutionRecusive(int[] arr, int i) {
        if(i == arr.length) return arr;

        for(int j=i; j>0; j--) {
            if(arr[j] < arr[j-1]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }

        return solutionRecusive(arr, i+1);
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr = {333,44,2,63,8,1};

        int[] result = insertionSort.solution(arr);
        int[] resultRecusive = insertionSort.solutionRecusive(arr, 1);

        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.toString(resultRecusive));
    }
}
