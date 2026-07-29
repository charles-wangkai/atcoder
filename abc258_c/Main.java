import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int Q = sc.nextInt();
    String S = sc.next();
    int[] types = new int[Q];
    int[] x = new int[Q];
    for (int i = 0; i < Q; ++i) {
      types[i] = sc.nextInt();
      x[i] = sc.nextInt();
    }

    System.out.println(solve(S, types, x));

    sc.close();
  }

  static String solve(String S, int[] types, int[] x) {
    List<Character> result = new ArrayList<>();
    int beginIndex = 0;
    for (int i = 0; i < types.length; ++i) {
      if (types[i] == 1) {
        beginIndex = Math.floorMod(beginIndex - x[i], S.length());
      } else {
        result.add(S.charAt((beginIndex + x[i] - 1) % S.length()));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}