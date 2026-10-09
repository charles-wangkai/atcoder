import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.printf("%.9f\n", solve(A, B));

    sc.close();
  }

  static double solve(int[] A, int[] B) {
    Deque<Segment> deque = new ArrayDeque<>();
    for (int i = 0; i < A.length; ++i) {
      deque.offer(new Segment(A[i], B[i]));
    }

    double result = 0;
    while (!deque.isEmpty()) {
      if (deque.size() == 1) {
        result += deque.poll().length / 2;
      } else {
        double leftTime = deque.peekFirst().getTime();
        double rightTime = deque.peekLast().getTime();
        if (leftTime < rightTime) {
          result += deque.pollFirst().length;
          deque.peekLast().length -= leftTime * deque.peekLast().speed;
        } else {
          double leftLength = rightTime * deque.peekFirst().speed;
          result += leftLength;
          deque.peekFirst().length -= leftLength;

          deque.pollLast();
        }
      }
    }

    return result;
  }
}

class Segment {
  double length;
  int speed;

  Segment(double length, int speed) {
    this.length = length;
    this.speed = speed;
  }

  double getTime() {
    return length / speed;
  }
}
