import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(H, W, queries));

    sc.close();
  }

  static String solve(int H, int W, String[] queries) {
    int Q = queries.length;

    int[] result = new int[Q];
    for (int i = 0; i < result.length; ++i) {
      int[] fields = Arrays.stream(queries[i].split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int R = fields[1];

        result[i] = R * W;
        H -= R;
      } else {
        int C = fields[1];

        result[i] = H * C;
        W -= C;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}