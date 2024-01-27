import java.util.*;

public class DepthFirstSearch {
    static class Edge {
        int source;
        int dest;

        Edge(int s, int d) {
            this.source = s;
            this.dest = d;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();// creating a Empty Array List in every Indexes OF Array
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

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static void printAllPaths(ArrayList<Edge> graph[], boolean vis[], String path, int curr, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                vis[curr] = true;
                printAllPaths(graph, vis, path + e.dest, e.dest, target);
                vis[e.dest] = false;

            }
        }

    }

    public static void main(String args[]) {
        int V = 7;
        // boolean vis[] = new boolean[V];
        ArrayList<Edge> graph[] = new ArrayList[V];
        // 1----------3
        // / | \
        // 0 | 5
        // \ | / \
        // 2----------4 6
        createGraph(graph);
        // for Disconned Component/ Graph
        // for (int i = 0; i < V; i++) {
        // if (vis[i] == false) {
        // dfs(graph, i, vis);
        // }
        // }

        // dfs(graph, 0, vis);
        int source = 0;
        int target = 5;
        printAllPaths(graph, new boolean[V], "0", source, target);

    }

}
