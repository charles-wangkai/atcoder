import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(a, queries));

    sc.close();
  }

  static String solve(int[] a, String[] queries) {
    FenwickTree fenwickTree = new FenwickTree(a.length);
    for (int i = 0; i < a.length; ++i) {
      fenwickTree.add(i + 1, a[i]);
    }

    List<Long> result = new ArrayList<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 0) {
        int p = fields[1];
        int x = fields[2];

        fenwickTree.add(p + 1, x);
      } else {
        int l = fields[1];
        int r = fields[2];

        result.add(fenwickTree.computePrefixSum(r) - fenwickTree.computePrefixSum(l));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class FenwickTree {
  long[] a;

  FenwickTree(int size) {
    a = new long[Integer.highestOneBit(size) * 2 + 1];
  }

  void add(int pos, int delta) {
    while (pos < a.length) {
      a[pos] += delta;
      pos += pos & -pos;
    }
  }

  long computePrefixSum(int pos) {
    long result = 0;
    while (pos != 0) {
      result += a[pos];
      pos -= pos & -pos;
    }

    return result;
  }
}
