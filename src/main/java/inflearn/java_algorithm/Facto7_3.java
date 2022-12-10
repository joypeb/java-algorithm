package inflearn.java_algorithm;

public class Facto7_3 {
    static int dfs(int n) {
        if(n == 1) return 1;
        else return n*dfs(n-1);
    }

    public static void main(String[] args) {
        System.out.println(dfs(5));
    }
}
