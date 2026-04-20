import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static char solve(String S) {
    int tCount = (int) S.chars().filter(c -> c == 'T').count();
    int aCount = (int) S.chars().filter(c -> c == 'A').count();

    if (tCount < aCount) {
      return 'A';
    }
    if (tCount > aCount) {
      return 'T';
    }

    return (S.charAt(S.length() - 1) == 'T') ? 'A' : 'T';
  }
}