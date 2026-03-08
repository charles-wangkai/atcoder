public class Main {
  public static void main(String[] args) {
    System.out.println(solve());
  }

  @SuppressWarnings("unused")
  static String solve() {
    boolean a = true;
    boolean b = false;
    boolean c = true;

    StringBuilder result = new StringBuilder();
    if (a) {
      result.append("At");
    } else {
      result.append("Yo");
    }

    if (!a && b) {
      result.append("Bo");
    } else if (!b || c) {
      result.append("Co");
    }

    if (a && b && c) {
      result.append("foo!");
    } else if (true && false) {
      result.append("yeah!");
    } else if (!a || c) {
      result.append("der");
    }

    return result.toString();
  }
}