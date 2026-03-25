import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String S, String T) {
    List<Integer> result = new ArrayList<>();
    int index = 0;
    for (char c : S.toCharArray()) {
      while (T.charAt(index) != c) {
        ++index;
      }

      result.add(index + 1);
      ++index;
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}