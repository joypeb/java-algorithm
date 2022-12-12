package inflearn.java_algorithm;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BinarySearchDFS7_5 {
    Node root;
    static void dfs(Node root) {
        if(root == null) return;
        else {
            //전위순회
            //System.out.println(root.data);
            dfs(root.lt);
            //중위순회
            System.out.println(root.data);
            dfs(root.rt);
            //후위순회
            //System.out.println(root.data);
        }
    }

    public static void main(String[] args) {
        BinarySearchDFS7_5 bs = new BinarySearchDFS7_5();

        bs.root = new Node(1);
        bs.root.lt = new Node(2);
        bs.root.rt = new Node(3);

        bs.root.lt.lt = new Node(4);
        bs.root.lt.rt = new Node(5);

        bs.root.rt.lt = new Node(6);
        bs.root.rt.rt = new Node(7);

        dfs(bs.root);
    }
}
