import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S1 = sc.next();
    String S2 = sc.next();
    String S3 = sc.next();
    String T = sc.next();

    System.out.println(solve(S1, S2, S3, T));

    sc.close();
  }

  static String solve(String S1, String S2, String S3, String T) {
    String[] S = {S1, S2, S3};

    return T.chars().mapToObj(c -> S[c - '0' - 1]).collect(Collectors.joining());
  }
}