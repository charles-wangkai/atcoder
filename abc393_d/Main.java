import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    int[] oneIndices = IntStream.range(0, S.length()).filter(i -> S.charAt(i) == '1').toArray();

    long result = 0;
    for (int i = 0, j = oneIndices.length - 1; i < j; ++i, --j) {
      result += oneIndices[j] - oneIndices[i] - (j - i);
    }

    return result;
  }
}