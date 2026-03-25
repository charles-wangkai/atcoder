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

  static String solve(String S) {
    return (IntStream.range(0, S.length()).filter(i -> S.charAt(i) == '1').findFirst().getAsInt()
                % 2
            == 0)
        ? "Takahashi"
        : "Aoki";
  }
}