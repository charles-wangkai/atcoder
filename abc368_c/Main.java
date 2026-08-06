import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }

    System.out.println(solve(H));

    sc.close();
  }

  static long solve(int[] H) {
    long result = 0;
    int index = 0;
    for (int Hi : H) {
      result += Hi / 5 * 3;
      Hi %= 5;

      while (Hi > 0) {
        Hi -= (index == 2) ? 3 : 1;
        index = (index + 1) % 3;
        ++result;
      }
    }

    return result;
  }
}