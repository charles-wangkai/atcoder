import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    return Arrays.stream(S.split("\\|"))
        .mapToInt(String::length)
        .filter(length -> length != 0)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}