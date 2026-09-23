import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String S = sc.next();
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(S, C, M));

    sc.close();
  }

  static String solve(String S, int[] C, int M) {
    Map<Integer, List<Integer>> colorToIndices = new HashMap<>();
    for (int i = 0; i < C.length; ++i) {
      colorToIndices.putIfAbsent(C[i], new ArrayList<>());
      colorToIndices.get(C[i]).add(i);
    }

    char[] result = new char[S.length()];
    for (List<Integer> indices : colorToIndices.values()) {
      for (int i = 0; i < indices.size(); ++i) {
        result[indices.get((i + 1) % indices.size())] = S.charAt(indices.get(i));
      }
    }

    return String.valueOf(result);
  }
}