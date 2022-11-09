package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] solutionSort(int[] arr, Sort sort) {
        for(int i=0; i< arr.length; i++) {
            for(int j=i+1; j< arr.length; j++) {
                if(sort.selectionSort(arr[i],arr[j])) {
                    int swap = arr[j];
                    arr[j] = arr[i];
                    arr[i] = swap;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,9,10,223,111,23,3,39};

        Sort desc = (a,b) -> a < b;
        Sort asc = (a,b) -> a > b;

        SelectionSort selectionSort = new SelectionSort();

        int[] descArr = selectionSort.solutionSort(arr,desc);
        int[] ascArr = selectionSort.solutionSort(arr,asc);

        System.out.println(Arrays.toString(descArr));
        System.out.println(Arrays.toString(ascArr));
    }
}

interface Sort {
    boolean selectionSort(int a, int b);
}
