import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(queries));

    sc.close();
  }

  static String solve(String[] queries) {
    List<Long> result = new ArrayList<>();
    List<Long> heads = new ArrayList<>();
    long head = 0;
    int beginIndex = 0;
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int l = fields[1];

        heads.add(head);
        head += l;
      } else if (fields[0] == 2) {
        ++beginIndex;
      } else {
        int k = fields[1];

        result.add(heads.get(beginIndex + k - 1) - heads.get(beginIndex));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}