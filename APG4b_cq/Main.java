import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    char op = sc.next().charAt(0);
    int B = sc.nextInt();

    System.out.println(solve(A, op, B));

    sc.close();
  }

  static String solve(int A, char op, int B) {
    if (op == '+') {
      return String.valueOf(A + B);
    }
    if (op == '-') {
      return String.valueOf(A - B);
    }
    if (op == '*') {
      return String.valueOf(A * B);
    }
    if (op == '/') {
      if (B == 0) {
        return "error";
      }

      return String.valueOf(A / B);
    }

    return "error";
  }
}