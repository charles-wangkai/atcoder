import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }

    System.out.println(solve(H, M));

    sc.close();
  }

  static int solve(int[] H, int M) {
    int result = 0;
    for (int Hi : H) {
      if (Hi > M) {
        break;
      }

      ++result;
      M -= Hi;
    }

    return result;
  }
}