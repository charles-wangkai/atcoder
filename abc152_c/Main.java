import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P));

    sc.close();
  }

  static int solve(int[] P) {
    int result = 0;
    int min = Integer.MAX_VALUE;
    for (int Pi : P) {
      if (Pi < min) {
        min = Pi;
        ++result;
      }
    }

    return result;
  }
}