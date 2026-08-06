import java.util.Arrays;
import java.util.Scanner;

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
    Arrays.sort(L);

    int result = 0;
    for (int i = 0; i < L.length; ++i) {
      int endIndex = 0;
      for (int j = i + 1; j < L.length; ++j) {
        while (endIndex != L.length - 1 && L[endIndex + 1] < L[i] + L[j]) {
          ++endIndex;
        }

        result += endIndex - j;
      }
    }

    return result;
  }
}