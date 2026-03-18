import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int A, int B) {
    for (int price = 1; ; ++price) {
      int tax1 = price * 8 / 100;
      if (tax1 > A) {
        return -1;
      }

      if (tax1 == A && price / 10 == B) {
        return price;
      }
    }
  }
}