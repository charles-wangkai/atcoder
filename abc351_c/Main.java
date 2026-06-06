import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    List<Integer> sequence = new ArrayList<>();
    for (int Ai : A) {
      sequence.add(Ai);

      while (sequence.size() >= 2
          && sequence.get(sequence.size() - 2).equals(sequence.get(sequence.size() - 1))) {
        int value = sequence.removeLast();
        sequence.removeLast();

        sequence.add(value + 1);
      }
    }

    return sequence.size();
  }
}