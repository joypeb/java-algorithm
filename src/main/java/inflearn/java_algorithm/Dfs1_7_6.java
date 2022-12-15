package inflearn.java_algorithm;

public class Dfs1_7_6 {
    static int n;
    static int[] ch;
    public static void dfs(int L) {
        if(L==n+1) {
            String tmp = "";
            for(int i=1; i<=n; i++) {
                if(ch[i] == 1) tmp += i + " ";
            }
            if(tmp.length() > 0)
                System.out.println(tmp);
            return;
        }
        ch[L] = 1;
        dfs(L+1);
        ch[L] = 0;
        dfs(L+1);
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n+1];
        dfs(1);
    }
}
