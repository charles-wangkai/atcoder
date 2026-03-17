import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] L = new int[N];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(L));

    sc.close();
  }

  static int solve(int[] L) {
    int result = 0;
    for (int i = 0; i < L.length; ++i) {
      for (int j = i + 1; j < L.length; ++j) {
        for (int k = j + 1; k < L.length; ++k) {
          if (isValid(L[i], L[j], L[k])) {
            ++result;
          }
        }
      }
    }

    return result;
  }

  static boolean isValid(int length1, int length2, int length3) {
    int[] sorted = IntStream.of(length1, length2, length3).sorted().toArray();

    return sorted[0] != sorted[1] && sorted[1] != sorted[2] && sorted[0] + sorted[1] > sorted[2];
  }
}