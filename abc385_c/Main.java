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

  static int solve(int[] H) {
    int result = 1;
    for (int beginIndex = 0; beginIndex < H.length; ++beginIndex) {
      for (int d = 1; beginIndex + d < H.length; ++d) {
        result = Math.max(result, computeBuildingNum(H, beginIndex, d));
      }
    }

    return result;
  }

  static int computeBuildingNum(int[] H, int beginIndex, int d) {
    int result = 0;
    for (int i = beginIndex; i < H.length && H[i] == H[beginIndex]; i += d) {
      ++result;
    }

    return result;
  }
}