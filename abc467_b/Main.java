import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    String[] S = new String[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
      S[i] = sc.next();
    }

    System.out.println(solve(A, B, S));

    sc.close();
  }

  static int solve(int[] A, int[] B, String[] S) {
    return IntStream.range(0, S.length)
        .filter(i -> S[i].equals("keep"))
        .map(i -> B[i] - A[i])
        .sum();
  }
}