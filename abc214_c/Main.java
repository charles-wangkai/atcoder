import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] S = new int[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.nextInt();
    }
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(int[] S, int[] T) {
    int N = S.length;

    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::time));
    for (int i = 0; i < T.length; ++i) {
      pq.offer(new Element(T[i], i));
    }

    int[] times = new int[N];
    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (times[head.index()] == 0) {
        times[head.index()] = head.time();

        pq.offer(new Element(head.time() + S[head.index()], (head.index() + 1) % N));
      }
    }

    return Arrays.stream(times).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

record Element(int time, int index) {}
