import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] squares = new char[8][8];
    for (int r = 0; r < 8; ++r) {
      String line = sc.next();
      for (int c = 0; c < 8; ++c) {
        squares[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(squares));

    sc.close();
  }

  static int solve(char[][] squares) {
    Set<Integer> rowSeen = new HashSet<>();
    Set<Integer> colSeen = new HashSet<>();
    for (int r = 0; r < 8; ++r) {
      for (int c = 0; c < 8; ++c) {
        if (squares[r][c] == '#') {
          rowSeen.add(r);
          colSeen.add(c);
        }
      }
    }

    int result = 0;
    for (int r = 0; r < 8; ++r) {
      for (int c = 0; c < 8; ++c) {
        if (!rowSeen.contains(r) && !colSeen.contains(c)) {
          ++result;
        }
      }
    }

    return result;
  }
}