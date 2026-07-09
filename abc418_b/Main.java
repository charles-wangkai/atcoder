import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println("%.9f".formatted(solve(S)));

    sc.close();
  }

  static double solve(String S) {
    double result = 0;
    for (int beginIndex = 0; beginIndex < S.length(); ++beginIndex) {
      for (int endIndex = beginIndex; endIndex < S.length(); ++endIndex) {
        result = Math.max(result, computeFillingRate(S.substring(beginIndex, endIndex + 1)));
      }
    }

    return result;
  }

  static double computeFillingRate(String t) {
    if (t.length() < 3 || !t.startsWith("t") || !t.endsWith("t")) {
      return 0;
    }

    return (t.chars().filter(c -> c == 't').count() - 2.0) / (t.length() - 2);
  }
}