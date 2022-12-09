package algorithm.dp;

public class LCS {
    public static void main(String[] args) {
        String st1 = "ABCDCBA"; //열
        String st2 = "DCABDC"; //행

        //st2인 DCABDC를 i로 놓고 바깥쪽에서 반복할 예쩡
        //st1을 j로 놓고 안쪽에서 반복할 예정

        int[][] dp = new int[st2.length()][st1.length()];

        for(int i=0; i< st2.length(); i++) {
            for(int j=0; j<st1.length(); j++) {
                System.out.println("i = " + st2.charAt(i) + ", j = " + st1.charAt(j));
            }
        }
    }
}
