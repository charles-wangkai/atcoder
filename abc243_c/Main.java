import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }
    String S = sc.next();

    System.out.println(solve(X, Y, S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] X, int[] Y, String S) {
    Map<Integer, List<Integer>> yToIndices = new HashMap<>();
    for (int i = 0; i < Y.length; ++i) {
      yToIndices.putIfAbsent(Y[i], new ArrayList<>());
      yToIndices.get(Y[i]).add(i);
    }

    for (List<Integer> indices : yToIndices.values()) {
      Collections.sort(indices, Comparator.comparing(index -> X[index]));

      boolean seenRight = false;
      for (int index : indices) {
        if (S.charAt(index) == 'L') {
          if (seenRight) {
            return true;
          }
        } else {
          seenRight = true;
        }
      }
    }

    return false;
  }
}