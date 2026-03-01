import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    Character[] sorted = S.chars().sorted().mapToObj(c -> (char) c).toArray(Character[]::new);

    return sorted[0] == sorted[1] && sorted[1] != sorted[2] && sorted[2] == sorted[3];
  }
}