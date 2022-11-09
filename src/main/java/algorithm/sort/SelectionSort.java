package algorithm.sort;

import java.util.Arrays;
import java.util.function.BiFunction;

public class SelectionSort {
    public int[] solutionSort(int[] arr, BiFunction<Integer,Integer, Boolean> stmt) {
        int swap = 0;
        for(int i=0; i< arr.length; i++) {
            int swapIndex = i;
            for(int j=i+1; j< arr.length; j++) {
                if(stmt.apply(arr[swapIndex],arr[j])) {
                    swapIndex = j;
                }
            }
            swap = arr[swapIndex];
            arr[swapIndex] = arr[i];
            arr[i] = swap;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,9,10,223,111,23,3,39};

        Sort desc = (a,b) -> a < b;
        Sort asc = (a,b) -> a > b;

        SelectionSort selectionSort = new SelectionSort();

        BiFunction<Integer,Integer,Boolean> sortStrategy = (a,b) -> a<b;

        int[] descArr = selectionSort.solutionSort(arr,sortStrategy);
        //int[] ascArr = selectionSort.solutionSort(arr,asc);

        System.out.println(Arrays.toString(descArr));
        //System.out.println(Arrays.toString(ascArr));
    }
}

interface Sort {
    boolean selectionSort(int a, int b);
}
