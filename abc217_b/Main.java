import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] S = new String[3];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String[] S) {
    Set<String> set = Arrays.stream(S).collect(Collectors.toSet());

    return Stream.of("ABC", "ARC", "AGC", "AHC").filter(s -> !set.contains(s)).findAny().get();
  }
}