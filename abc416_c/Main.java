import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int X = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, K, X));

    sc.close();
  }

  static String solve(String[] S, int K, int X) {
    List<String> strings = new ArrayList<>();
    search(strings, S, new int[K], 0);
    Collections.sort(strings);

    return strings.get(X - 1);
  }

  static void search(List<String> strings, String[] S, int[] indices, int depth) {
    if (depth == indices.length) {
      strings.add(Arrays.stream(indices).mapToObj(index -> S[index]).collect(Collectors.joining()));

      return;
    }

    for (int i = 0; i < S.length; ++i) {
      indices[depth] = i;
      search(strings, S, indices, depth + 1);
    }
  }
}