import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();

        System.out.println(solve(s));

        sc.close();
    }

    static int solve(int s) {
        Set<Integer> seen = new HashSet<>();
        seen.add(s);
        int current = s;
        for (int m = 2;; ++m) {
            current = (current % 2 == 0) ? (current / 2) : (current * 3 + 1);
            if (seen.contains(current)) {
                return m;
            }

            seen.add(current);
        }
    }
}