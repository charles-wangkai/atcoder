import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N) {
    String s = String.valueOf(N);

    return IntStream.range(0, s.length() - 1).allMatch(i -> s.charAt(i) > s.charAt(i + 1));
  }
}