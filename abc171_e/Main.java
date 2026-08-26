import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int totalXor = Arrays.stream(a).reduce(0, (acc, x) -> acc ^ x);

    return Arrays.stream(a)
        .map(ai -> totalXor ^ ai)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}