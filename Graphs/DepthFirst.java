import java.util.*;

public class DepthFirst {
    public static class Edge {
        int source;
        int dest;

        Edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                DFS(graph, e.dest, vis);

            }
        }
    }

    public static void FindAllPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                vis[curr] = true;
                FindAllPaths(graph, vis, e.dest, path + e.dest, target);
                vis[curr] = false;
            }
        }
    }

    public static void main(String args[]) {
        ArrayList<Edge> graph[] = new ArrayList[7];
        boolean vis[] = new boolean[7];
        creatGraph(graph, 7);
        // DFS(graph, 0, vis);
        int source = 0, dest = 5;
        FindAllPaths(graph, vis, source, "0", dest);

    }
}
