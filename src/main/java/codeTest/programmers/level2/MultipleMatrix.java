package codeTest.programmers.level2;

public class MultipleMatrix {
    //행렬의 곱셈

    /*
    * 행렬의 곱은 arr1[0][i]에 해당하는 부분과 arr2[i][0]에 해당하는 부분을 곱한다
    * 그리고 그 다음에는 arr1[0][i]와 arr2[i][1]에 해당하는 부분을 곱한다
    *
    * 그러므로 곱한 행렬의 크기는 [arr1.length][arr2[0].length]에 해당한다
    *
    *  arr1    arr2
    *  2 3 2   5 4 3
    *  4 2 4   2 4 1
    *  3 1 4   3 1 1
    *
    *  먼저 첫번째로 arr1[i][0]에 해당되는 흐름으로 행렬이 지나간다
    *  그리고 두번째로 arr2[0][i]에 해당되는 흐름
    *  세번째로 arr2[i][0]에 해당되는 흐름이다
    *  arr1[i].length와 arr2.length는 같기때문에 두 개를 곱한뒤 더해주면 하나의 행렬 원소가 완성된다
    *  이를 반복하면 된다
    * */

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                int sum = 0;
                for(int k=0; k<arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
