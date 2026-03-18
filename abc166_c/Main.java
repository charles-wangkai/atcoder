import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(H, A, B));

    sc.close();
  }

  static int solve(int[] H, int[] A, int[] B) {
    int N = H.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      adjLists[A[i] - 1].add(B[i] - 1);
      adjLists[B[i] - 1].add(A[i] - 1);
    }

    return (int)
        IntStream.range(0, N)
            .filter(i -> adjLists[i].stream().allMatch(adj -> H[adj] < H[i]))
            .count();
  }
}