import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int W = sc.nextInt();
    int[] S = new int[N];
    int[] T = new int[N];
    int[] P = new int[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.nextInt();
      T[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }

    System.out.println(solve(S, T, P, W) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] S, int[] T, int[] P, int W) {
    List<Event> events = new ArrayList<>();
    for (int i = 0; i < S.length; ++i) {
      events.add(new Event(S[i], P[i]));
      events.add(new Event(T[i], -P[i]));
    }
    Collections.sort(events, Comparator.comparing(Event::time).thenComparing(Event::delta));

    int sum = 0;
    for (Event event : events) {
      sum += event.delta();
      if (sum > W) {
        return false;
      }
    }

    return true;
  }
}

record Event(int time, int delta) {}
