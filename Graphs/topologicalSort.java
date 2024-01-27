import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> stack) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, vis, e.dest, stack);
            }
        }
        stack.push(curr);

    }

    public static void topologicalSort(ArrayList<Edge> graph[], int V) {
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, vis, i, stack);
            }

        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        topologicalSort(graph, V);

    }

}
