import java.util.*;

public class graph1 {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 1));

    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // printing Neighbours
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.source + "-> " + e.dest);
        }

    }
}