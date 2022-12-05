package algorithm.sort;

import java.util.Arrays;

public class Heap1 {
    static int[] getChildren(int[] arr, int idx) {
        int first = idx*2+1;
        int second = idx*2+2;
        System.out.println(first + " " +second);
        System.out.println(arr.length);

        if(first +1 >= arr.length)
            return new int[]{arr[second]};
        else if(second +1 >= arr.length)
            return new int[]{arr[first]};
        else if(first +1 >= arr.length && second +1 >= arr.length)
            return null;
        else
            return new int[]{arr[first],arr[second]};
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8};

        int[] child = getChildren(arr,1);
        System.out.println(Arrays.toString(child));
    }
}
