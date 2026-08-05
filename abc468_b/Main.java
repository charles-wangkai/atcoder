import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int D = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, D));

    sc.close();
  }

  static int solve(String S, int D) {
    char[] cells = S.toCharArray();
    for (int i = 0; i < cells.length; ++i) {
      if (cells[i] == 'G') {
        for (int j = i - D; j <= i + D; ++j) {
          if (j >= 0 && j < cells.length && cells[j] == '.') {
            cells[j] = '*';
          }
        }
      }
    }

    return (int) IntStream.range(0, cells.length).filter(i -> cells[i] == '.').count();
  }
}