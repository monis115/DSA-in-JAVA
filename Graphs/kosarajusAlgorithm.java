import java.util.*;

public class kosarajusAlgorithm {
    public static class Edge {
        int src;
        int dst;
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public static void Kosaraju(ArrayList<Edge> graph[], int V) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

    }

    public static void main(String args[]) {

    }

}