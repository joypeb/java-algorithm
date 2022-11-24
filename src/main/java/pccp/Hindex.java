package pccp;

import java.util.Arrays;

public class Hindex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int num = citations[citations.length-1];

        for(int i=num; i>=0; i--) {
            int cnt = 0;
            inner: for(int j= citations.length-1; j>=0; j--) {
                if(i <= citations[j]) {
                    cnt++;
                } else {
                    break inner;
                }
            }
            if(cnt == i) {
                answer = i;
                break;
            } else if(cnt >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Hindex hindex = new Hindex();

        int[] arr = {0,1,2,3,5,5,5,6};
        int[] arr2 =  {0,1,1};

        /*System.out.println(hindex.solution(arr));*/
        System.out.println(hindex.solution(arr2));
    }
}
