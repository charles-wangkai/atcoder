import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    int result = 0;
    int[] pieces = new int[0];
    for (int Ai : A) {
      int[] advanced =
          IntStream.concat(IntStream.of(0), Arrays.stream(pieces)).map(x -> x + Ai).toArray();

      result += Arrays.stream(advanced).filter(x -> x >= 4).count();
      pieces = Arrays.stream(advanced).filter(x -> x < 4).toArray();
    }

    return result;
  }
}