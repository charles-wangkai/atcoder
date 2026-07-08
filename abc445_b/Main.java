import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String[] S) {
    int m = Arrays.stream(S).mapToInt(String::length).max().getAsInt();

    return Arrays.stream(S)
        .map(
            Si ->
                "%s%s%s"
                    .formatted(
                        ".".repeat((m - Si.length()) / 2), Si, ".".repeat((m - Si.length()) / 2)))
        .collect(Collectors.joining("\n"));
  }
}