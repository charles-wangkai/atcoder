public class Main {
  public static void main(String[] args) {
    System.out.println(solve());
  }

  static String solve() {
    return "%d\n%d\n%d\n%d"
        .formatted(
            computeSecondsInYear(1),
            computeSecondsInYear(2),
            computeSecondsInYear(5),
            computeSecondsInYear(10));
  }

  static int computeSecondsInYear(int year) {
    return year * 365 * 24 * 60 * 60;
  }
}