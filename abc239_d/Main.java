import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(A, B, C, D));

    sc.close();
  }

  static String solve(int A, int B, int C, int D) {
    return IntStream.rangeClosed(A, B)
            .anyMatch(x -> IntStream.rangeClosed(C, D).allMatch(y -> !isPrime(x + y)))
        ? "Takahashi"
        : "Aoki";
  }

  static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}