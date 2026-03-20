import java.util.List;
import java.util.Scanner;

public class Main {
  static final List<String> DAYS = List.of("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int result = 0;
    int index = DAYS.indexOf(S);
    while (true) {
      ++result;
      index = (index + 1) % DAYS.size();

      if (DAYS.get(index).equals("SUN")) {
        return result;
      }
    }
  }
}