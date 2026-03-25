import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static final Map<String, String> ENGLISH_TO_ATCODERISH =
      Map.ofEntries(entry("red", "SSS"), entry("blue", "FFF"), entry("green", "MMM"));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    return ENGLISH_TO_ATCODERISH.getOrDefault(S, "Unknown");
  }
}