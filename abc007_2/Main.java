import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String A = sc.next();

      System.out.println(solve(A));
    }
  }

  static String solve(String A) {
    return A.equals("a") ? "-1" : "a";
  }
}