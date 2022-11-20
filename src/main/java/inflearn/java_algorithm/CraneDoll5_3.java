package inflearn.java_algorithm;

import java.util.Scanner;
import java.util.Stack;

public class CraneDoll5_3 {
    public int solution(int[][] arr, int[] basketArr) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<basketArr.length; i++) {
            int catchNum = 0;
            int bNum = basketArr[i]-1;
            crane:for(int j=0; j<arr.length; j++) {
                if(arr[j][bNum]!=0) {
                    catchNum = arr[j][bNum];
                    arr[j][bNum] = 0;
                    break crane;
                }
            }

            System.out.println(catchNum);

            if(catchNum == 0) continue;
            else {
                if(stack.empty()) {
                    stack.push(catchNum);
                } else{
                    int lastNum = stack.peek();

                    if(lastNum == catchNum){
                        stack.pop();
                        result+=2;
                    } else {
                        stack.push(catchNum);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CraneDoll5_3 main = new CraneDoll5_3();

        int arrNum = sc.nextInt();
        int[][] arr = new int[arrNum][arrNum];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int basketNum = sc.nextInt();
        int[] basketArr = new int[basketNum];

        for(int i=0; i<basketArr.length; i++) {
            basketArr[i] = sc.nextInt();
        }

        int result = main.solution(arr,basketArr);

        System.out.println(result);
    }
}
