import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] P = new int[26];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P));

    sc.close();
  }

  static String solve(int[] P) {
    return Arrays.stream(P)
        .mapToObj(Pi -> (char) (Pi - 1 + 'a'))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}