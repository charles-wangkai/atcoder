import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();

    System.out.println(solve(H));

    sc.close();
  }

  static int solve(int H) {
    int height = 0;
    for (int i = 0; ; ++i) {
      height += 1 << i;
      if (height > H) {
        return i + 1;
      }
    }
  }
}