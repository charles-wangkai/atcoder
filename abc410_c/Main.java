import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    String[] queries = new String[Q];
    sc.nextLine();
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(N, queries));

    sc.close();
  }

  static String solve(int N, String[] queries) {
    List<Integer> result = new ArrayList<>();
    int[] values = IntStream.rangeClosed(1, N).toArray();
    int offset = 0;
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int p = fields[1];
        int x = fields[2];

        values[(p - 1 + offset) % N] = x;
      } else if (fields[0] == 2) {
        int p = fields[1];

        result.add(values[(p - 1 + offset) % N]);
      } else {
        int k = fields[1];

        offset = (offset + k) % N;
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}