package algorithm.sort;

import java.util.Arrays;

public class QuickSort3 {

    int[] solution(int[] arr) {
        //정렬하기위한 배열과 left, right값 전달
        return quickSort(arr, 0, arr.length-1);
    }

    //재귀함수로 동작하게 된다
    int[] quickSort(int[] arr, int left, int right) {

        //1. 먼저 part를 구하기 위해 partition함수를 실햄한다
        int part = partition(arr, left, right);

        //9. left의 위치를 반환받아 part에 넣게되면 배열을 반으로 쪼갠 위치가 나오게된다
        //여기서 left가 part-1보다 작을때까지 계속 실행시켜주는데
        //배열이 한개일경우 part가 1이되게되고 part-1은 0이어서 정렬할 필요가 없기 때문이다
        if(left < part-1) {
            //10. 재귀를 이용해 왼쪽 배열들을 정렬시켜준다.
            //왼쪽 배열이기때문에 배열의 오른쪽이 part-1이 되었다
            quickSort(arr, left, part-1);
        }
        if(part < right) {
            //11. 재귀를 이용해 오른쪽 배열들을 정렬시켜준다
            //오른쪽 배열이기때문에 배열의 왼쪽이 part가 되었다
            quickSort(arr, part, right);
        }

        return arr;
    }

    int partition(int[] arr, int left, int right) {
        //2. partition함수에서 왼쪽과 오른쪽의 합을 나누어 중간값 pivot을 구한다
        int pivot = arr[(left+right)/2];

        //3. left가 right보다 커지거나 같아질때까지 반복문을 돌린다
        while(left <= right) {
            //4. left에 위치한 배열의 값이 pivot보다 작을경우 패스한다
            //5. right에 위치한 배여의 값이 pivot보다 클경우 패스한다
            //이렇게되면 left에서 pivot보다 큰 값이 나올경우 while문이 멈추어서 그 값을 유지한다
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            //6. left가 right보다 작거나 같을때 서로 두 수를 바꿔준다
            //7. 그리고 left와 right를 한칸씩 이동시켜준다
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }

            //이 코드를 left가 right보다 작거나 갈을때까지 반복시킨다
        }
        //8. 그리고 left의 위치를 반환시키게 된다
        return left;
    }

    //값을 서로 바꿔주는 메서드
    void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort3 quickSort3 = new QuickSort3();

        int[] arr = {3,9,1,6,10,2,7};

        int[] result = quickSort3.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
