import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] A = new int[M][];
    for (int i = 0; i < A.length; ++i) {
      int K = sc.nextInt();
      A[i] = new int[K];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(B, A));

    sc.close();
  }

  static String solve(int[] B, int[][] A) {
    int N = B.length;
    int M = A.length;

    int[] rests = new int[M];
    Map<Integer, List<Integer>> ingredientToDishes = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      rests[i] = A[i].length;

      for (int ingredient : A[i]) {
        ingredientToDishes.putIfAbsent(ingredient, new ArrayList<>());
        ingredientToDishes.get(ingredient).add(i);
      }
    }

    int[] result = new int[N];
    int eatNum = 0;
    for (int i = 0; i < result.length; ++i) {
      for (int dish : ingredientToDishes.getOrDefault(B[i], List.of())) {
        --rests[dish];
        if (rests[dish] == 0) {
          ++eatNum;
        }
      }

      result[i] = eatNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}