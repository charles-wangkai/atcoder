import java.util.List;
import java.util.Scanner;

public class Main {
  static final List<String> VERSIONS = List.of("Ocelot", "Serval", "Lynx");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String X = sc.next();
    String Y = sc.next();

    System.out.println(solve(X, Y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String X, String Y) {
    return VERSIONS.indexOf(X) >= VERSIONS.indexOf(Y);
  }
}