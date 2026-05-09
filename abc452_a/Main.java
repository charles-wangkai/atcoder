import java.util.List;
import java.util.Scanner;

public class Main {
  static final List<MonthDay> SEASONAL_FESTIVALS =
      List.of(
          new MonthDay(1, 7),
          new MonthDay(3, 3),
          new MonthDay(5, 5),
          new MonthDay(7, 7),
          new MonthDay(9, 9));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(M, D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int M, int D) {
    return SEASONAL_FESTIVALS.contains(new MonthDay(M, D));
  }
}

record MonthDay(int month, int day) {}
