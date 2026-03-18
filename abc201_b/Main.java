import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    int[] T = new int[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.next();
      T[i] = sc.nextInt();
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String[] S, int[] T) {
    return S[
        IntStream.range(0, T.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> T[i]).reversed())
            .skip(1)
            .findFirst()
            .get()];
  }
}