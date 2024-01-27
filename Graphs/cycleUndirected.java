import java.util.*;

public class cycleUndirected {
    public static class Edge {
        int source;
        int dest;

        Edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }

    public static boolean isCycle(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == true && parent != e.dest) {
                return true;
            } else if (!vis[e.dest]) {
                if (isCycle(graph, vis, e.dest, curr))
                    return true;
            }

        }

        return false;

    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        System.out.println(isCycle(graph, new boolean[V], 0, -1));

    }

}
