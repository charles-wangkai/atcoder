import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[] S = new char[3];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next().charAt(0);
    }
    char[] T = new char[3];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.next().charAt(0);
    }

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[] S, char[] T) {
    int diffCount = (int) IntStream.range(0, S.length).filter(i -> S[i] != T[i]).count();

    return diffCount == 0 || diffCount == 3;
  }
}