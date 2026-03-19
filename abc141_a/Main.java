import java.util.List;
import java.util.Scanner;

public class Main {
  static final List<String> WEATHERS = List.of("Sunny", "Cloudy", "Rainy");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    return WEATHERS.get((WEATHERS.indexOf(S) + 1) % WEATHERS.size());
  }
}