import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P));

    sc.close();
  }

  static String solve(int[] P) {
    return Arrays.stream(P)
        .map(Pi -> (int) Arrays.stream(P).filter(x -> x > Pi).count() + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}