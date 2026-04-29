import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[] c = new char[N];
    long[] l = new long[N];
    for (int i = 0; i < N; ++i) {
      c[i] = sc.next().charAt(0);
      l[i] = sc.nextLong();
    }

    System.out.println(solve(c, l));

    sc.close();
  }

  static String solve(char[] c, long[] l) {
    long length = 0;
    for (long li : l) {
      length += li;
      if (length > 100) {
        return "Too Long";
      }
    }

    return IntStream.range(0, c.length)
        .mapToObj(i -> String.valueOf(c[i]).repeat((int) l[i]))
        .collect(Collectors.joining());
  }
}