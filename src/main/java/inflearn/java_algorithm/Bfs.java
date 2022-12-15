package inflearn.java_algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 lt, rt;
    public Node2(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Bfs {
    Node2 root;
    static void dfs(Node2 root) {
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            System.out.println("L = "+ L + " ");
            for(int i=0; i<len; i++) {
                Node2 cur = q.poll();
                System.out.println("cur = " + cur.data + " ");
                if(cur.lt != null) q.offer(cur.lt);
                if(cur.rt != null) q.offer(cur.rt);
            }
            L++;
        }
    }

    public static void main(String[] args) {
        Bfs bs = new Bfs();

        bs.root = new Node2(1);
        bs.root.lt = new Node2(2);
        bs.root.rt = new Node2(3);

        bs.root.lt.lt = new Node2(4);
        bs.root.lt.rt = new Node2(5);

        bs.root.rt.lt = new Node2(6);
        bs.root.rt.rt = new Node2(7);

        dfs(bs.root);
    }
}
