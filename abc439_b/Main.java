import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N) {
    Set<Integer> seen = new HashSet<>();
    int current = N;
    while (true) {
      if (current == 1) {
        return true;
      }
      if (seen.contains(current)) {
        return false;
      }
      seen.add(current);

      current = String.valueOf(current).chars().map(c -> (c - '0') * (c - '0')).sum();
    }
  }
}