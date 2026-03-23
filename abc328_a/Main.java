import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] S = new int[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.nextInt();
    }

    System.out.println(solve(S, X));

    sc.close();
  }

  static int solve(int[] S, int X) {
    return Arrays.stream(S).filter(Si -> Si <= X).sum();
  }
}