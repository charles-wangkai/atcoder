public class Main {
  public static void main(String[] args) {
    System.out.println(solve());
  }

  static String solve() {
    int seconds = 365 * 24 * 60 * 60;

    return "%d\n%d\n%d\n%d".formatted(seconds, seconds * 2, seconds * 5, seconds * 10);
  }
}