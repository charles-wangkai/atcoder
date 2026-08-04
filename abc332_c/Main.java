import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int M = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, M));

    sc.close();
  }

  static int solve(String S, int M) {
    int plainWashed = M;
    int plainWorn = 0;
    int logoWashed = 0;
    int logoWorn = 0;
    for (char c : S.toCharArray()) {
      if (c == '0') {
        plainWashed += plainWorn;
        plainWorn = 0;

        logoWashed += logoWorn;
        logoWorn = 0;
      } else if (c == '1' && plainWashed != 0) {
        --plainWashed;
        ++plainWorn;
      } else {
        if (logoWashed != 0) {
          --logoWashed;
        }

        ++logoWorn;
      }
    }

    return logoWashed + logoWorn;
  }
}