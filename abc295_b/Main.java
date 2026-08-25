import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int C = sc.nextInt();
    char[][] B = new char[R][C];
    for (int r = 0; r < R; ++r) {
      String line = sc.next();
      for (int c = 0; c < C; ++c) {
        B[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(B));

    sc.close();
  }

  static String solve(char[][] B) {
    int R = B.length;
    int C = B[0].length;

    char[][] result = new char[R][];
    for (int r = 0; r < R; ++r) {
      result[r] = B[r].clone();
    }

    for (int r = 0; r < R; ++r) {
      for (int c = 0; c < C; ++c) {
        if (Character.isDigit(B[r][c])) {
          for (int adjR = 0; adjR < R; ++adjR) {
            for (int adjC = 0; adjC < C; ++adjC) {
              if (Math.abs(adjR - r) + Math.abs(adjC - c) <= B[r][c] - '0') {
                result[adjR][adjC] = '.';
              }
            }
          }
        }
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}