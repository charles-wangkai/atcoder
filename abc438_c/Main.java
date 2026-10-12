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
    List<Segment> segments = new ArrayList<>();
    for (int Ai : A) {
      if (!segments.isEmpty() && segments.getLast().value == Ai) {
        ++segments.getLast().count;
        if (segments.getLast().count == 4) {
          segments.removeLast();
        }
      } else {
        segments.add(new Segment(Ai, 1));
      }
    }

    return segments.stream().mapToInt(segment -> segment.count).sum();
  }
}

class Segment {
  int value;
  int count;

  Segment(int value, int count) {
    this.value = value;
    this.count = count;
  }
}
