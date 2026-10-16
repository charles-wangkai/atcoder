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
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(A, queries));

    sc.close();
  }

  static String solve(int[] A, String[] queries) {
    int N = A.length;

    long[] prefixSums = new long[N + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + A[i - 1];
    }

    List<Long> result = new ArrayList<>();
    int offset = 0;
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int c = fields[1];

        offset = (offset + c) % N;
      } else {
        int l = fields[1];
        int r = fields[2];

        int fromIndex = (l - 1 + offset) % N;
        int toIndex = (r - 1 + offset) % N;

        result.add(
            (fromIndex <= toIndex)
                ? computeRangeSum(prefixSums, fromIndex, toIndex)
                : (computeRangeSum(prefixSums, fromIndex, N - 1)
                    + computeRangeSum(prefixSums, 0, toIndex)));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static long computeRangeSum(long[] prefixSums, int beginIndex, int endIndex) {
    return prefixSums[endIndex + 1] - prefixSums[beginIndex];
  }
}