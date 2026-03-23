import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String S, String T) {
    return IntStream.range(0, S.length())
        .mapToObj(i -> "%c%c".formatted(S.charAt(i), T.charAt(i)))
        .collect(Collectors.joining());
  }
}