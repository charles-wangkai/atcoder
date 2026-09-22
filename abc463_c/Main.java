import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] H = new int[N];
    int[] L = new int[N];
    for (int i = 0; i < N; ++i) {
      H[i] = sc.nextInt();
      L[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] T = new int[Q];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(H, L, T));

    sc.close();
  }

  static String solve(int[] H, int[] L, int[] T) {
    int N = H.length;

    int[] maxHeights = new int[N];
    for (int i = maxHeights.length - 1; i >= 0; --i) {
      maxHeights[i] = Math.max(H[i], (i == maxHeights.length - 1) ? -1 : maxHeights[i + 1]);
    }

    return Arrays.stream(T)
        .map(
            Ti -> {
              int index = -1;
              int lower = 0;
              int upper = L.length - 1;
              while (lower <= upper) {
                int middle = (lower + upper) / 2;
                if (L[middle] > Ti) {
                  index = middle;
                  upper = middle - 1;
                } else {
                  lower = middle + 1;
                }
              }

              return maxHeights[index];
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}