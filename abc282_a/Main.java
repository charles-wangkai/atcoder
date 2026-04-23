import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static String solve(int K) {
    return IntStream.range(0, K)
        .mapToObj(i -> (char) ('A' + i))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}