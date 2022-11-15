package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public List<Integer> merge(List<Integer> left, List<Integer> mid, List<Integer> right) {
        List<Integer> answer = new ArrayList<>();
        answer.addAll(left);
        answer.addAll(mid);
        answer.addAll(right);

        return answer;
    }

    public List<Integer> sort(List<Integer> arr) {

        if(arr.size()<=1) return arr;

        //1. 기준값 뽑는 로직 구현
        int pivot = arr.get(arr.size()/2);

        //2. 기준값을 기준으로 왼, 오로 나누어 남는 로직 구현
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        for(int i=0; i< arr.size(); i++) {
            if(pivot > arr.get(i)) {
                left.add(arr.get(i));
            } else if(pivot < arr.get(i)) {
                right.add(arr.get(i));
            } else {
                mid.add(arr.get(i));
            }
        }

        return merge(left,mid,right);
    }

    public static void main(String[] args) {
        int[] arr = {20,18,5,19,5,25,40,50};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        List<Integer> result = new ArrayList<>();

        QuickSort quickSort = new QuickSort();

        result = quickSort.sort(list);

        System.out.println(result);
    }
}
