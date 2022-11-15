package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public List<Integer> sort(List<Integer> arr) {

        //1. 기준값 뽑는 로직 구현
        int pivot = arr.get(arr.size()/2);

        //2. 기준값을 기준으로 왼, 오로 나누어 남는 로직 구현
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i=0; i< arr.size(); i++) {
            if(pivot > arr.get(i)) {
                left.add(arr.get(i));
            } else if(pivot < arr.get(i)) {
                right.add(arr.get(i));
            }
        }

        return sort(left) + pivot + sort(right);
    }

    public static void main(String[] args) {
        int[] arr = {20,18,5,19,5,25,40,50};

    }
}
