import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] u = new int[M];
    int[] v = new int[M];
    for (int i = 0; i < M; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(N, u, v));

    sc.close();
  }

  static int solve(int N, int[] u, int[] v) {
    return u.length
        - (int)
            IntStream.range(0, u.length)
                .filter(i -> u[i] != v[i])
                .mapToObj(i -> new Edge(Math.min(u[i], v[i]), Math.max(u[i], v[i])))
                .distinct()
                .count();
  }
}

record Edge(int node1, int node2) {}
