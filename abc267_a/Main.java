import java.util.List;
import java.util.Scanner;

public class Main {
  static final List<String> WEEKDAYS =
      List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return WEEKDAYS.size() - WEEKDAYS.indexOf(S);
  }
}