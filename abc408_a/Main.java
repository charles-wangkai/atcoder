import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int S = sc.nextInt();
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(T, S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] T, int S) {
    return IntStream.range(0, T.length).allMatch(i -> T[i] - ((i == 0) ? 0 : T[i - 1]) <= S);
  }
}