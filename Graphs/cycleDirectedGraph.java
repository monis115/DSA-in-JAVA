import java.util.*;

public class cycleDirectedGraph {
    public static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> grap[], int V) {
        for (int i = 0; i < V; i++) {
            grap[i] = new ArrayList<Edge>();
        }
        grap[0].add(new Edge(1, 0));

        grap[1].add(new Edge(0, 2));

        grap[2].add(new Edge(2, 3));

        // grap[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[], boolean visit[], int curr, boolean stack[]) {
        visit[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) {
                return true;
            } else if (!visit[e.dest]) {
                if (isCycle(graph, visit, e.dest, stack))
                    return true;
            }

        }
        visit[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        boolean vis[] = new boolean[V];
        boolean stack[] = new boolean[V];
        System.out.println(isCycle(graph, vis, 1, stack));

    }

}
