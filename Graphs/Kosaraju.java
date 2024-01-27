import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
    public static class Edge {
        int src;
        int dst;

        Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));

    }

    public static void topologicalSort(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                topologicalSort(graph, vis, e.dst, s);
            }
        }
        s.push(curr);
    }

    public static void Dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // System.out.print(curr + " ");
        vis[curr] = true;
        System.out.print(curr);
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst])
                Dfs(graph, e.dst, vis);
        }

    }

    public static void kosarajusAlgorithm(ArrayList<Edge> graph[], int V) {
        Stack<Integer> s = new Stack<Integer>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i])
                topologicalSort(graph, vis, i, s);
        }
        ArrayList<Edge> tranpose[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            tranpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                tranpose[e.dst].add(new Edge(e.dst, e.src));
            }
        }
        while (!s.isEmpty()) {
            int curr = s.pop();
            // System.out.print(curr);
            if (!vis[curr]) {
                Dfs(tranpose, curr, vis);
                System.out.println();

            }

        }

    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        kosarajusAlgorithm(graph, V);

    }

}
