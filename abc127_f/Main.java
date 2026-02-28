import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(queries));

    sc.close();
  }

  static String solve(String[] queries) {
    PriorityQueue<Integer> leftHalf = new PriorityQueue<>(Collections.reverseOrder());
    long leftSum = 0;

    PriorityQueue<Integer> rightHalf = new PriorityQueue<>();
    long rightSum = 0;

    List<String> result = new ArrayList<>();
    int middle = Integer.MIN_VALUE;
    long bSum = 0;
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("1")) {
        int a = Integer.parseInt(fields[1]);
        int b = Integer.parseInt(fields[2]);

        if (middle == Integer.MIN_VALUE) {
          if (leftHalf.isEmpty() || a <= leftHalf.peek()) {
            leftHalf.offer(a);
            leftSum += a;

            middle = leftHalf.poll();
            leftSum -= middle;
          } else {
            rightHalf.offer(a);
            rightSum += a;

            middle = rightHalf.poll();
            rightSum -= middle;
          }
        } else {
          if (a <= middle) {
            leftHalf.offer(a);
            leftSum += a;

            rightHalf.offer(middle);
            rightSum += middle;
          } else {
            leftHalf.offer(middle);
            leftSum += middle;

            rightHalf.offer(a);
            rightSum += a;
          }

          middle = Integer.MIN_VALUE;
        }

        bSum += b;
      } else {
        int x = (middle == Integer.MIN_VALUE) ? leftHalf.peek() : middle;
        long fx = rightSum - leftSum + bSum;

        result.add("%d %d".formatted(x, fx));
      }
    }

    return String.join("\n", result);
  }
}