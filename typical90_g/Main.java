import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
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
    int[] B = new int[Q];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int[] A, int[] B) {
    NavigableSet<Integer> aSet = new TreeSet<>();
    for (int Ai : A) {
      aSet.add(Ai);
    }

    return Arrays.stream(B)
        .map(
            Bi -> {
              int result = Integer.MAX_VALUE;

              Integer floor = aSet.floor(Bi);
              if (floor != null) {
                result = Math.min(result, Bi - floor);
              }

              Integer ceiling = aSet.ceiling(Bi);
              if (ceiling != null) {
                result = Math.min(result, ceiling - Bi);
              }

              return result;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}