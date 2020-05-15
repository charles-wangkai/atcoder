import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        Set<Integer> written = new HashSet<>();
        for (int Ai : A) {
            if (written.contains(Ai)) {
                written.remove(Ai);
            } else {
                written.add(Ai);
            }
        }

        return written.size();
    }
}