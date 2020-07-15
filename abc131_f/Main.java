import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        System.out.println(solve(x, y));

        sc.close();
    }

    static long solve(int[] x, int[] y) {
        int N = x.length;

        Map<Integer, List<Integer>> xValueToIndices = new HashMap<>();
        Map<Integer, List<Integer>> yValueToIndices = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            if (!xValueToIndices.containsKey(x[i])) {
                xValueToIndices.put(x[i], new ArrayList<>());
            }
            xValueToIndices.get(x[i]).add(i);

            if (!yValueToIndices.containsKey(y[i])) {
                yValueToIndices.put(y[i], new ArrayList<>());
            }
            yValueToIndices.get(y[i]).add(i);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] adjLists = new List[N];
        for (int i = 0; i < adjLists.length; ++i) {
            adjLists[i] = new ArrayList<>();
        }

        for (List<Integer> indices : Stream.concat(xValueToIndices.values().stream(), yValueToIndices.values().stream())
                .collect(Collectors.toList())) {
            for (int i = 0; i < indices.size(); ++i) {
                if (i != 0) {
                    adjLists[indices.get(i)].add(indices.get(i - 1));
                }
                if (i != indices.size() - 1) {
                    adjLists[indices.get(i)].add(indices.get(i + 1));
                }
            }
        }

        long result = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; ++i) {
            if (!visited[i]) {
                List<Integer> group = new ArrayList<>();
                search(group, adjLists, visited, i);

                int xValueNum = (int) group.stream().mapToInt(index -> x[index]).distinct().count();
                int yValueNum = (int) group.stream().mapToInt(index -> y[index]).distinct().count();

                result += (long) xValueNum * yValueNum - group.size();
            }
        }

        return result;
    }

    static void search(List<Integer> group, List<Integer>[] adjLists, boolean[] visited, int node) {
        group.add(node);
        visited[node] = true;

        for (int adj : adjLists[node]) {
            if (!visited[adj]) {
                search(group, adjLists, visited, adj);
            }
        }
    }
}