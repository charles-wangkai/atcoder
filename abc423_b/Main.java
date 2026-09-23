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
    int[] indices = IntStream.range(0, L.length).filter(i -> L[i] == 1).toArray();

    return (indices.length == 0) ? 0 : (indices[indices.length - 1] - indices[0]);
  }
}