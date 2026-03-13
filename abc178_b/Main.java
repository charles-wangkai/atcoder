import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    System.out.println(solve(a, b, c, d));

    sc.close();
  }

  static long solve(int a, int b, int c, int d) {
    return LongStream.of((long) a * c, (long) a * d, (long) b * c, (long) b * d).max().getAsLong();
  }
}