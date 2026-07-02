import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String c = sc.next();

    System.out.println(solve(c));

    sc.close();
  }

  static int solve(String c) {
    return (int)
        c.substring(0, (int) c.chars().filter(x -> x == 'R').count())
            .chars()
            .filter(x -> x == 'W')
            .count();
  }
}