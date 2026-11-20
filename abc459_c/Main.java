import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int Q = sc.nextInt();
      sc.nextLine();
      String[] queries = new String[Q];
      for (int i = 0; i < queries.length; ++i) {
        queries[i] = sc.nextLine();
      }

      System.out.println(solve(N, queries));
    }
  }

  static String solve(int N, String[] queries) {
    List<Integer> result = new ArrayList<>();
    int[] counts = new int[N];
    int base = 0;
    FenwickTree fenwickTree = new FenwickTree(queries.length);
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int x = fields[1];

        if (counts[x - 1] != 0) {
          fenwickTree.add(counts[x - 1], -1);
        }

        ++counts[x - 1];
        fenwickTree.add(counts[x - 1], 1);

        if (fenwickTree.computePrefixSum(fenwickTree.a.length - 1)
                - fenwickTree.computePrefixSum(base)
            == N) {
          ++base;
        }
      } else {
        int y = fields[1];

        result.add(
            fenwickTree.computePrefixSum(fenwickTree.a.length - 1)
                - fenwickTree.computePrefixSum(Math.min(fenwickTree.a.length - 1, base + y - 1)));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class FenwickTree {
  int[] a;

  FenwickTree(int size) {
    a = new int[size + 1];
  }

  void add(int pos, int delta) {
    while (pos < a.length) {
      a[pos] += delta;
      pos += pos & -pos;
    }
  }

  int computePrefixSum(int pos) {
    int result = 0;
    while (pos != 0) {
      result += a[pos];
      pos -= pos & -pos;
    }

    return result;
  }
}
