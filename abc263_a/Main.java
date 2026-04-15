import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int D = sc.nextInt();
    int E = sc.nextInt();

    System.out.println(solve(A, B, C, D, E) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int A, int B, int C, int D, int E) {
    int[] sorted = IntStream.of(A, B, C, D, E).sorted().toArray();

    return sorted[0] == sorted[1]
        && sorted[3] == sorted[4]
        && (sorted[2] == sorted[0] || sorted[2] == sorted[4]);
  }
}