package codeTest.programmers.level2;

public class Carpet {
    //카펫

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        int h = 0;

        for(int w=sum/2; w>2; w--){
            if(sum%w == 0) {
                h = sum/w;
                if((w-2)*(h-2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }

        return answer;
    }
}
