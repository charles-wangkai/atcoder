import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(A, queries));

    sc.close();
  }

  static String solve(int[] A, String[] queries) {
    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int k = fields[1];
        int x = fields[2];

        A[k - 1] = x;
      } else {
        int k = fields[1];

        result.add(A[k - 1]);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}