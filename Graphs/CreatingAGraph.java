import java.util.*;

public class CreatingAGraph {
    public static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Function For Creating Graph
    public static void creatGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();// creating a empty ArrayList Of type Edge in every bucket
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

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[7];
        creatGraph(graph, V);
        // printg All The Neighbours
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.println(e.source + "-> " + e.dest);

            }
            System.out.println();
        }
    }

}
