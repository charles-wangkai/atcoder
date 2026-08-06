import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int W = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, W));

    sc.close();
  }

  static int solve(int[] A, int W) {
    Set<Integer> goods = new HashSet<>();
    for (int Ai : A) {
      goods.add(Ai);
    }
    for (int i = 0; i < A.length; ++i) {
      for (int j = i + 1; j < A.length; ++j) {
        goods.add(A[i] + A[j]);
      }
    }
    for (int i = 0; i < A.length; ++i) {
      for (int j = i + 1; j < A.length; ++j) {
        for (int k = j + 1; k < A.length; ++k) {
          goods.add(A[i] + A[j] + A[k]);
        }
      }
    }

    return (int) goods.stream().filter(x -> x <= W).count();
  }
}