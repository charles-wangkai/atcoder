import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String O = sc.next();
    String E = sc.next();

    System.out.println(solve(O, E));

    sc.close();
  }

  static String solve(String O, String E) {
    return IntStream.range(0, O.length() + E.length())
        .mapToObj(i -> ((i % 2 == 0) ? O : E).charAt(i / 2))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}