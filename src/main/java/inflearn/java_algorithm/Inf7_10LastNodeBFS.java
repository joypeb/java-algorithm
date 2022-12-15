package inflearn.java_algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Inf7_10LastNodeBFS {
    Node root;

    static int bfs(Node root) {
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        int L = 0;

        while(!q.isEmpty()) {
            int len = q.size();

            for(int i=0; i<len; i++) {
                Node cur = q.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) q.offer(cur.lt);
                if(cur.rt != null) q.offer(cur.rt);
            }
            L++;
        }

        return L;
    }

    public static void main(String[] args) {
        Inf7_10LastNodeBFS tree = new Inf7_10LastNodeBFS();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(bfs(tree.root));
    }
}
