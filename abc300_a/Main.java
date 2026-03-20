import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(C, A, B));

    sc.close();
  }

  static int solve(int[] C, int A, int B) {
    return IntStream.range(0, C.length).filter(i -> C[i] == A + B).findAny().getAsInt() + 1;
  }
}