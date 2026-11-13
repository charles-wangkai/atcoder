import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(int X) {
    return IntStream.rangeClosed(1, 3).filter(x -> x != X).findAny().getAsInt();
  }
}