package algorithm.sort;

import java.util.Arrays;

public class QuickSort2 {
    int[] solution(int[] arr) {
        int pivot = arr[arr.length/2];
        int leftIdx = 0;
        int rightIdx = arr.length-1;

        while(arr[leftIdx]<pivot) {
            leftIdx++;
        }

        while(arr[rightIdx]>pivot) {
            rightIdx--;
        }

        int temp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = temp;

        leftIdx++;
        rightIdx++;

        return arr;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();

        int[] arr = {25,18,5,19,20,5,50,40};

        int[] result = quickSort2.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
