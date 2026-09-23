import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    char[] H = new char[Q];
    int[] T = new int[Q];
    for (int i = 0; i < Q; ++i) {
      H[i] = sc.next().charAt(0);
      T[i] = sc.nextInt();
    }

    System.out.println(solve(N, H, T));

    sc.close();
  }

  static int solve(int N, char[] H, int[] T) {
    int result = 0;
    int[] positions = {0, 1};
    for (int i = 0; i < H.length; ++i) {
      int index = (H[i] == 'L') ? 0 : 1;
      int toPos = T[i] - 1;

      result += computeOperationNum(N, positions[index], toPos, positions[1 - index]);

      positions[index] = toPos;
    }

    return result;
  }

  static int computeOperationNum(int N, int pos1, int pos2, int blockedPos) {
    if (pos1 > pos2) {
      return computeOperationNum(N, pos2, pos1, blockedPos);
    }

    return (blockedPos > pos1 && blockedPos < pos2) ? (N - (pos2 - pos1)) : (pos2 - pos1);
  }
}