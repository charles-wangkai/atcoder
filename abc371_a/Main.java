import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char Sab = sc.next().charAt(0);
    char Sac = sc.next().charAt(0);
    char Sbc = sc.next().charAt(0);

    System.out.println(solve(Sab, Sac, Sbc));

    sc.close();
  }

  static char solve(char Sab, char Sac, char Sbc) {
    if (Sab == '<') {
      if (Sac == '<') {
        return (Sbc == '<') ? 'B' : 'C';
      }

      return 'A';
    }

    if (Sac == '<') {
      return 'A';
    }

    return (Sbc == '<') ? 'C' : 'B';
  }
}