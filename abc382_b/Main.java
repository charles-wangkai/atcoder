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

  static String solve(String S, int D) {
    int[] indices = IntStream.range(0, S.length()).filter(i -> S.charAt(i) == '@').toArray();

    char[] result = S.toCharArray();
    for (int i = 0; i < D; ++i) {
      result[indices[indices.length - 1 - i]] = '.';
    }

    return String.valueOf(result);
  }
}