import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[][] table = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        table[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(table) ? "correct" : "incorrect");

    sc.close();
  }

  static boolean solve(char[][] table) {
    int N = table.length;

    for (int r = 0; r < N; ++r) {
      for (int c = r + 1; c < N; ++c) {
        if (!check(table[r][c], table[c][r])) {
          return false;
        }
      }
    }

    return true;
  }

  static boolean check(char result1, char result2) {
    return (result1 == 'W' && result2 == 'L')
        || (result1 == 'L' && result2 == 'W')
        || (result1 == 'D' && result2 == 'D');
  }
}