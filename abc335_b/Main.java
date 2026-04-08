import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    List<Triple> triples = new ArrayList<>();
    for (int x = 0; x <= N; ++x) {
      for (int y = 0; x + y <= N; ++y) {
        for (int z = 0; x + y + z <= N; ++z) {
          triples.add(new Triple(x, y, z));
        }
      }
    }

    return triples.stream()
        .map(triple -> "%d %d %d".formatted(triple.x(), triple.y(), triple.z()))
        .collect(Collectors.joining("\n"));
  }
}

record Triple(int x, int y, int z) {}
