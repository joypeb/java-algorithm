package inflearn.java_algorithm;

public class Recursion7_1 {

    static void dfs(int n) {
        if(n < 0) return;
        //sout을 위에두면 10 -> 0으로
        //밑에두면 0 -> 10으로 출력된다
        dfs(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        dfs(10);

        /*
               재귀는 스택이다
         */
    }
}
