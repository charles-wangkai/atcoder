import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }

    System.out.println(solve(H));

    sc.close();
  }

  static int solve(int[] H) {
    return IntStream.range(0, H.length).boxed().max(Comparator.comparing(i -> H[i])).get() + 1;
  }
}