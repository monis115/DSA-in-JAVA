import java.util.*;

public class PrimsAlgorithm {
    public static class Edge {
        int src;
        int dst;
        int wt;

        Edge(int s, int d, int wt) {
            this.src = s;
            this.dst = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 40));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 3, 15));
        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 0, 40));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 15));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static class Pair implements Comparable<Pair> {
        int node1;
        int node2;
        int cost;

        Pair(int n, int n2, int c) {
            this.node1 = n;
            this.node2 = n2;
            this.cost = c;
        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;// Ascending Order
        }
    }

    public static void prims(ArrayList<Edge> graph[], int V, int src) {
        ArrayList<Pair> mstList = new ArrayList<Pair>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        int mstCost = 0;
        pq.add(new Pair(src, src, 0));
        boolean visited[] = new boolean[V];
        int dis[] = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node2]) {
                vis[curr.node2] = true;
                mstCost += curr.cost;
                mstList.add(new Pair(curr.node1, curr.node2, curr.cost));
                for (int i = 0; i < graph[curr.node2].size(); i++) {

                    Edge e = graph[curr.node2].get(i);
                    int u = e.src;
                    int v = e.dst;

                    if (!vis[e.dst]) {
                        pq.add(new Pair(e.src, e.dst, e.wt));
                    }
                }
            }

        }
        for (int i = 0; i < mstList.size(); i++) {
            Pair p = mstList.get(i);
            if (p.node1 != p.node2)
                System.out.println(p.node1 + "->" + p.node2 + " " + p.cost);
        }

        System.out.println("The MST - " + mstCost);
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        prims(graph, V, 0);

    }
}
