package inflearn.java_algorithm;

public class Inf7_9LastNodeDFS {
    Node root;

    static int dfs(int L, Node root) {
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(dfs(L+1, root.lt), dfs(L+1, root.rt));
    }

    public static void main(String[] args) {
        Inf7_9LastNodeDFS tree = new Inf7_9LastNodeDFS();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(dfs(0, tree.root));
    }
}
