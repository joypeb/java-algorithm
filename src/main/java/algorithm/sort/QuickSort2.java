package algorithm.sort;

import java.util.Arrays;

public class QuickSort2 {
    int[] solution(int[] arr) {
        int pivot = arr[arr.length/2];

        for(int i=0; i<arr.length; i++) {

        }

        return arr;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();

        int[] arr = {20,18,5,19,25,5,50,40};

        int[] result = quickSort2.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
