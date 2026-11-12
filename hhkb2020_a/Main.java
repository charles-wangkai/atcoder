import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char S = sc.next().charAt(0);
    char T = sc.next().charAt(0);

    System.out.println(solve(S, T));

    sc.close();
  }

  static char solve(char S, char T) {
    return (S == 'Y') ? Character.toUpperCase(T) : T;
  }
}