package algorithm.sort;

public class BubbleSort01 {
    public int[] solution(int[] arr) {
        int temp = arr[0];

        for(int i=0; i< arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {7,28,32,41,2,112};
        //오름차순, 내림차순으로 정렬하는 알고리즘을 짜보세요

        BubbleSort01 bs = new BubbleSort01();

        int[] resultAsc = bs.solution(arr);


        for(int x : resultAsc) {
            System.out.print(x + ", ");
        }
    }
}
