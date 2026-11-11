import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }
    int M = sc.nextInt();
    String[] S = new String[M];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(A, B, S));

    sc.close();
  }

  static String solve(int[] A, int[] B, String[] S) {
    int N = A.length;

    @SuppressWarnings("unchecked")
    Set<Character>[] letterSets = new Set[N];
    for (int i = 0; i < letterSets.length; ++i) {
      letterSets[i] = new HashSet<>();
    }

    for (String Si : S) {
      for (int i = 0; i < N; ++i) {
        if (A[i] == Si.length()) {
          letterSets[i].add(Si.charAt(B[i] - 1));
        }
      }
    }

    return Arrays.stream(S)
        .map(Si ->
            (Si.length() == N
                    && IntStream.range(0, Si.length())
                        .allMatch(i -> letterSets[i].contains(Si.charAt(i))))
                ? "Yes"
                : "No")
        .collect(Collectors.joining("\n"));
  }
}