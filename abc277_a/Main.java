import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P, X));

    sc.close();
  }

  static int solve(int[] P, int X) {
    return IntStream.range(0, P.length).filter(i -> P[i] == X).findAny().getAsInt() + 1;
  }
}