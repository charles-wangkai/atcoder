import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    System.out.println(solve());
  }

  static int solve() {
    return IntStream.rangeClosed(1, 100).sum();
  }
}