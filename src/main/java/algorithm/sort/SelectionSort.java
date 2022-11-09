package algorithm.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,7,4,9,10,223,111,23,3,39};

        int min = arr[0];

        for(int i=1; i< arr.length; i++) {
            if(min > arr[i]) {
                int swap = arr[i];
                arr[i] = min;
                min = swap;
            }
        }

        System.out.println(min);
    }
}
