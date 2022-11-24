package pccp;

import java.util.Arrays;

public class Hindex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++) {

            if(citations.length-i >= citations[i]) {
                return citations.length-i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Hindex hindex = new Hindex();

        int[] arr = {6, 5, 5, 5, 3, 2, 1, 0};

        System.out.println(hindex.solution(arr));
    }
}
