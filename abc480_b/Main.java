import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }
    String[] T = new String[M];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.next();
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String[] S, String[] T) {
    Map<String, Integer> nameToIndex =
        IntStream.range(0, S.length).boxed().collect(Collectors.toMap(i -> S[i], i -> i));

    int[] result = new int[S.length];
    for (String Ti : T) {
      if (nameToIndex.containsKey(Ti)) {
        ++result[nameToIndex.get(Ti)];
      } else {
        int[] indices =
            IntStream.range(0, S.length)
                .filter(i ->
                    S[i].length() == Ti.length()
                        && IntStream.range(0, S[i].length())
                                .filter(j -> S[i].charAt(j) != Ti.charAt(j))
                                .count()
                            == 1)
                .toArray();
        if (indices.length == 1) {
          ++result[indices[0]];
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}