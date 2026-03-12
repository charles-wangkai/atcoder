import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static final Map<String, Integer> USERNAME_TO_RATING =
      Map.ofEntries(
          entry("tourist", 3858),
          entry("ksun48", 3679),
          entry("Benq", 3658),
          entry("Um_nik", 3648),
          entry("apiad", 3638),
          entry("Stonefeang", 3630),
          entry("ecnerwala", 3613),
          entry("mnbvmar", 3555),
          entry("newbiedmy", 3516),
          entry("semiexp", 3481));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return USERNAME_TO_RATING.get(S);
  }
}