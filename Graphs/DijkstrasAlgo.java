import java.util.*;

public class DijkstrasAlgo {
    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        public int compareTo(Pair p2) {
            return this.dist - p2.dist;// Ascending Order
        }

    }

    public static void DijkstrasAlgorithm(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int dis[] = new int[V];
        dis[0] = 0;
        for (int i = 1; i < V; i++) {

            dis[i] = Integer.MAX_VALUE;
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair currPair = pq.remove();
            if (!vis[currPair.node]) {
                vis[currPair.node] = true;
                for (int i = 0; i < graph[currPair.node].size(); i++) {
                    Edge e = graph[currPair.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (dis[u] + e.wt < dis[v]) {
                        dis[v] = dis[u] + e.wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.print(dis[i] + " ");
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        DijkstrasAlgorithm(graph, 0, V);
    }

}
