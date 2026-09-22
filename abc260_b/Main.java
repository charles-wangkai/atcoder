import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    int Z = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, X, Y, Z));

    sc.close();
  }

  static String solve(int[] A, int[] B, int X, int Y, int Z) {
    int N = A.length;

    boolean[] admitted = new boolean[N];

    int[] mathTops =
        IntStream.range(0, N)
            .filter(i -> !admitted[i])
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> A[i]).reversed().thenComparing(i -> i))
            .limit(X)
            .mapToInt(Integer::intValue)
            .toArray();
    for (int mathTop : mathTops) {
      admitted[mathTop] = true;
    }

    int[] englishTops =
        IntStream.range(0, N)
            .filter(i -> !admitted[i])
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> B[i]).reversed().thenComparing(i -> i))
            .limit(Y)
            .mapToInt(Integer::intValue)
            .toArray();
    for (int englishTop : englishTops) {
      admitted[englishTop] = true;
    }

    int[] totalTops =
        IntStream.range(0, N)
            .filter(i -> !admitted[i])
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> A[i] + B[i])
                    .reversed()
                    .thenComparing(i -> i))
            .limit(Z)
            .mapToInt(Integer::intValue)
            .toArray();
    for (int totalTop : totalTops) {
      admitted[totalTop] = true;
    }

    return IntStream.range(0, admitted.length)
        .filter(i -> admitted[i])
        .map(i -> i + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}