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
    int[] prefixSums = new int[A.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + A[i - 1];
    }

    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int x = fields[1];

        int temp = A[x - 1];
        A[x - 1] = A[x];
        A[x] = temp;

        prefixSums[x] = prefixSums[x - 1] + A[x - 1];
        prefixSums[x + 1] = prefixSums[x] + A[x];
      } else {
        int l = fields[1];
        int r = fields[2];

        result.add(prefixSums[r] - prefixSums[l - 1]);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}