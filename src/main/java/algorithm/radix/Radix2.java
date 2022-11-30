package algorithm.radix;

import java.util.*;

public class Radix2 {
    public static int[] radix(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // 중복제거 하여 자릿수 구하기
            if (arr[i] == 0) set.add(1);
            else set.add((int) (Math.log10(arr[i]) + 1));
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for (Integer num : set) {
            answer[idx++] = num;
        }
        Arrays.sort(answer); //정렬
        return answer;
    }

    public static int[] sort(int[] arr, int digit) {
        //큐 생성
        Queue<Integer>[] qArr = new Queue[10];
        for(int i=0; i<qArr.length; i++) {
            qArr[i] = new ArrayDeque<>();
        }

        //자릿수에 맞게 큐에 넣기
        for(int i=0; i<arr.length; i++) {
            int divisor = (int)Math.pow(10, digit-1);
            //10의 0제곱은 1의자리

            qArr[Math.floorDiv(arr[i],divisor)%10].add(arr[i]);
        }

        //큐에서 꺼내서 arr로 만들기
        int idx = 0;
        for(int i=0; i<qArr.length; i++) {
            while(!qArr[i].isEmpty()) {
                arr[idx++] = qArr[i].poll();
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 11233, 4, 5, 9, 1, 0, 20,111};
        int[] digits = radix(arr);
        System.out.println(Arrays.toString(digits));

        for (var digit : digits) {
            arr = sort(arr, digit);
        }

        System.out.println(Arrays.toString(arr));
    }
}
