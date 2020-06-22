import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();

        System.out.println(solve(L));

        sc.close();
    }

    static String solve(int L) {
        Graph graph = new Graph();
        search(graph, L);

        return String.format("%d %d\n%s", graph.vertexNum, graph.edges.size(),
                graph.edges.stream().map(edge -> String.format("%d %d %d", edge.from, edge.to, edge.weight))
                        .collect(Collectors.joining("\n")));
    }

    static void search(Graph graph, int pathNum) {
        if (pathNum == 1) {
            return;
        }

        int currentVertex = graph.vertexNum;

        ++graph.vertexNum;
        graph.edges.add(new Edge(currentVertex, graph.vertexNum, 0));
        graph.edges.add(new Edge(currentVertex, graph.vertexNum, pathNum / 2));

        search(graph, pathNum / 2);

        if (pathNum % 2 != 0) {
            graph.edges.add(new Edge(currentVertex, graph.vertexNum, pathNum - 1));
        }
    }
}

class Graph {
    int vertexNum = 1;
    List<Edge> edges = new ArrayList<>();
}

class Edge {
    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}