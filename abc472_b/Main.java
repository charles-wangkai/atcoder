import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] L = new int[N];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(L));

    sc.close();
  }

  static int solve(int[] L) {
    int total = Arrays.stream(L).sum();

    int result = Integer.MAX_VALUE;
    int leftSum = 0;
    for (int Li : L) {
      leftSum += Li;
      result = Math.min(result, Math.abs(leftSum - (total - leftSum)));
    }

    return result;
  }
}