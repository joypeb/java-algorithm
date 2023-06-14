package algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }


    @Override
    public int compareTo(Edge o) {
        return this.cost-o.cost;
    }
}

public class InfDijkstra {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static void main(String[] args) {
        InfDijkstra infDijkstra = new InfDijkstra();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b,c));
        }

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        //정점 1부터 시작
        infDijkstra.solution(1);
    }

    public void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(v,0));

        dis[v] = 0;

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();

            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost > dis[now]) continue;

            for(Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost+ ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost+ ob.cost));
                }
            }
        }
    }
}
