import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N) {
    return String.valueOf(N)
        .chars()
        .sorted()
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining())
        .equals("122333");
  }
}