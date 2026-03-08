import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<String> fields = new ArrayList<>();
    while (sc.hasNext()) {
      fields.add(sc.next());
    }

    System.out.println(solve(fields));

    sc.close();
  }

  static String solve(List<String> fields) {
    if (fields.get(0).equals("1")) {
      int price = Integer.parseInt(fields.get(1));
      int N = Integer.parseInt(fields.get(2));

      return String.valueOf(price * N);
    }

    String text = fields.get(1);
    int price = Integer.parseInt(fields.get(2));
    int N = Integer.parseInt(fields.get(3));

    return "%s!\n%d".formatted(text, price * N);
  }
}