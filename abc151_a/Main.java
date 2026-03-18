import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char C = sc.next().charAt(0);

    System.out.println(solve(C));

    sc.close();
  }

  static char solve(char C) {
    return (char) (C + 1);
  }
}