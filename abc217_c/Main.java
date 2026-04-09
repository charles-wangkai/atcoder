import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

    sc.close();
  }

  static String solve(int[] p) {
    int[] result = new int[p.length];
    for (int i = 0; i < p.length; ++i) {
      result[p[i] - 1] = i + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}