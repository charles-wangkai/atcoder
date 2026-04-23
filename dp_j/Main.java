import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(a)));

    sc.close();
  }

  static double solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    int total = Arrays.stream(a).sum();

    Map<State, Outcome> dp =
        Map.of(
            new State(
                0,
                valueToCount.getOrDefault(1, 0),
                valueToCount.getOrDefault(2, 0),
                valueToCount.getOrDefault(3, 0)),
            new Outcome(1, 0));
    for (int i = 0; i < total; ++i) {
      Map<State, Outcome> nextDp = new HashMap<>();
      for (State state : dp.keySet()) {
        Outcome outcome = dp.get(state);

        if (state.count1() != 0) {
          State nextState =
              new State(state.count0() + 1, state.count1() - 1, state.count2(), state.count3());

          nextDp.put(
              nextState,
              merge(
                  nextDp.get(nextState),
                  new Outcome(
                      outcome.prob()
                          * state.count1()
                          / (state.count1() + state.count2() + state.count3()),
                      outcome.expectedOperationNum()
                          + (double) a.length
                              / (state.count1() + state.count2() + state.count3()))));
        }
        if (state.count2() != 0) {
          State nextState =
              new State(state.count0(), state.count1() + 1, state.count2() - 1, state.count3());

          nextDp.put(
              nextState,
              merge(
                  nextDp.get(nextState),
                  new Outcome(
                      outcome.prob()
                          * state.count2()
                          / (state.count1() + state.count2() + state.count3()),
                      outcome.expectedOperationNum()
                          + (double) a.length
                              / (state.count1() + state.count2() + state.count3()))));
        }
        if (state.count3() != 0) {
          State nextState =
              new State(state.count0(), state.count1(), state.count2() + 1, state.count3() - 1);

          nextDp.put(
              nextState,
              merge(
                  nextDp.get(nextState),
                  new Outcome(
                      outcome.prob()
                          * state.count3()
                          / (state.count1() + state.count2() + state.count3()),
                      outcome.expectedOperationNum()
                          + (double) a.length
                              / (state.count1() + state.count2() + state.count3()))));
        }
      }

      dp = nextDp;
    }

    return dp.values().iterator().next().expectedOperationNum();
  }

  static Outcome merge(Outcome o1, Outcome o2) {
    if (o1 == null) {
      return o2;
    }

    return new Outcome(
        o1.prob() + o2.prob(),
        (o1.prob() * o1.expectedOperationNum() + o2.prob() * o2.expectedOperationNum())
            / (o1.prob() + o2.prob()));
  }
}

record State(int count0, int count1, int count2, int count3) {}

record Outcome(double prob, double expectedOperationNum) {}
