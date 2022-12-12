package pccp;

import java.util.Arrays;

public class TrainingRobot {
    //pccp 모의고사 2회 실습용 로봇

    public int[] solution(String command) {
        int[] answer = new int[2];

        char[] com = command.toCharArray();

        int[][] ewsn = {{0,1},{1,0},{0,-1},{-1,0}};

        int dirc = 0;

        for(int i=0; i<com.length; i++) {
            switch (com[i]) {
                case 'R' :
                    dirc++;
                    if(dirc > 3) dirc = 0;
                    break;
                case 'L' :
                    dirc--;
                    if(dirc < 0) dirc = 3;
                    break;
                case 'G':
                    answer[0] += ewsn[dirc][0];
                    answer[1] += ewsn[dirc][1];
                    break;
                default:
                    answer[0] -= ewsn[dirc][0];
                    answer[1] -= ewsn[dirc][1];
                    break;
            }
            System.out.println(Arrays.toString(answer));
        }

        return answer;
    }

    public static void main(String[] args) {
        TrainingRobot trainingRobot = new TrainingRobot();

        System.out.println(Arrays.toString(trainingRobot.solution("GRGRGRB")));
    }
}
