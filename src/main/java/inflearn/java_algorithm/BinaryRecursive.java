package inflearn.java_algorithm;

public class BinaryRecursive {
    static void dfs(int n) {
        if(n == 0) return;
        else {
            dfs(n/2);
            System.out.printf("%d",n%2);
        }
    }

    public static void main(String[] args) {
        dfs(11);
    }
}
