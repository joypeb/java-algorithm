package codeTest.programmers.level1;

public class MultipleMatrix {
    //행렬의 곱셈

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        int num = 0;

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1[0].length; j++) {
                for(int k=0; k< arr2.length; k++) {
                    num += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = num;
                num=0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MultipleMatrix multipleMatrix = new MultipleMatrix();

        int[][] test = { {1,4},{3,2},{4,1} };
        int[][] test2 = {{3,3},{3,3}};

        int[][] answer = multipleMatrix.solution(test,test2);

        for(int i=0; i< answer.length; i++) {
            for(int j=0; j<answer[0].length; j++) {
                System.out.println(answer[i][j]);
            }
        }
    }
}
