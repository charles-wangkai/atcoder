import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    char[] op = new char[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      op[i] = sc.next().charAt(0);
      B[i] = sc.nextInt();
    }

    System.out.println(solve(op, B, A));

    sc.close();
  }

  static String solve(char[] op, int[] B, int A) {
    List<String> output = new ArrayList<>();
    int value = A;
    for (int i = 0; i < op.length; ++i) {
      if (op[i] == '+') {
        value += B[i];
      } else if (op[i] == '-') {
        value -= B[i];
      } else if (op[i] == '*') {
        value *= B[i];
      } else if (B[i] == 0) {
        output.add("error");

        break;
      } else {
        value /= B[i];
      }

      output.add("%d:%d".formatted(output.size() + 1, value));
    }

    return String.join("\n", output);
  }
}