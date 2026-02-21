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
        List<Integer> lastValues = new ArrayList<>();
        for (int Ai : A) {
            int index = findIndex(lastValues, Ai);
            if (index == lastValues.size()) {
                lastValues.add(Ai);
            } else {
                lastValues.set(index, Ai);
            }
        }

        return lastValues.size();
    }

    static int findIndex(List<Integer> lastValues, int x) {
        int result = lastValues.size();
        int lower = 0;
        int upper = lastValues.size() - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (lastValues.get(middle) < x) {
                result = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return result;
    }
}