import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Ma = sc.nextInt();
        int Mb = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        System.out.println(solve(a, b, c, Ma, Mb));

        sc.close();
    }

    static int solve(int[] a, int[] b, int[] c, int Ma, int Mb) {
        Map<State, Integer> stateToCost = new HashMap<>();
        stateToCost.put(new State(0, 0), 0);

        for (int i = 0; i < a.length; ++i) {
            Map<State, Integer> nextStateToCost = new HashMap<>(stateToCost);
            for (State state : stateToCost.keySet()) {
                State nextState = new State(state.sumA + a[i], state.sumB + b[i]);

                nextStateToCost.put(nextState, Math.min(nextStateToCost.getOrDefault(nextState, Integer.MAX_VALUE),
                        stateToCost.get(state) + c[i]));
            }

            stateToCost = nextStateToCost;
        }

        return stateToCost.keySet().stream().filter(state -> state.sumA != 0 && state.sumA * Mb == state.sumB * Ma)
                .mapToInt(stateToCost::get).min().orElse(-1);
    }
}

class State {
    int sumA;
    int sumB;

    State(int sumA, int sumB) {
        this.sumA = sumA;
        this.sumB = sumB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sumA, sumB);
    }

    @Override
    public boolean equals(Object obj) {
        State other = (State) obj;

        return sumA == other.sumA && sumB == other.sumB;
    }
}