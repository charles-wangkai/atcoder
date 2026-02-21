import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(solve(s, x, y) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String s, int x, int y) {
        Set<State> xStates = new HashSet<>();
        xStates.add(new State(0, 1));

        Set<State> yStates = new HashSet<>();
        yStates.add(new State(0, 1));

        boolean xOrY = true;
        for (char command : s.toCharArray()) {
            if (command == 'F') {
                if (xOrY) {
                    xStates = xStates.stream().map(xState -> new State(xState.value + xState.offset, xState.offset))
                            .collect(Collectors.toSet());
                } else {
                    yStates = yStates.stream().map(yState -> new State(yState.value + yState.offset, yState.offset))
                            .collect(Collectors.toSet());
                }
            } else {
                xOrY = !xOrY;

                if (xOrY) {
                    xStates.addAll(xStates.stream().map(xState -> new State(xState.value, -xState.offset))
                            .collect(Collectors.toList()));
                } else {
                    yStates.addAll(yStates.stream().map(yState -> new State(yState.value, -yState.offset))
                            .collect(Collectors.toList()));
                }
            }
        }

        return xStates.stream().anyMatch(xState -> xState.value == x)
                && yStates.stream().anyMatch(yState -> yState.value == y);
    }
}

class State {
    int value;
    int offset;

    State(int value, int offset) {
        this.value = value;
        this.offset = offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, offset);
    }

    @Override
    public boolean equals(Object obj) {
        State other = (State) obj;

        return value == other.value && offset == other.offset;
    }
}