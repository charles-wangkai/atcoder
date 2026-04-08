import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return (int)
        IntStream.range(0, S.length())
            .boxed()
            .flatMap(i -> IntStream.range(i, S.length()).mapToObj(j -> S.substring(i, j + 1)))
            .distinct()
            .count();
  }
}