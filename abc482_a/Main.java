import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String S = sc.next();

      System.out.println(solve(S));
    }
  }

  static String solve(String S) {
    return (S.chars().filter(c -> c == 'o').count() % 2 == 1) ? "odd" : "even";
  }
}