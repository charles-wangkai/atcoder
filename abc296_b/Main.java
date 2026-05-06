import java.util.Scanner;

public class Main {
  static final int SIZE = 8;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] squares = new char[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      String line = sc.next();
      for (int c = 0; c < SIZE; ++c) {
        squares[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(squares));

    sc.close();
  }

  static String solve(char[][] squares) {
    for (int r = 0; ; ++r) {
      for (int c = 0; c < SIZE; ++c) {
        if (squares[r][c] == '*') {
          return "%c%d".formatted((char) ('a' + c), SIZE - r);
        }
      }
    }
  }
}