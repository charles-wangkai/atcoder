import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(K, X));

    sc.close();
  }

  static String solve(int K, int X) {
    return IntStream.rangeClosed(X - K + 1, X + K - 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}