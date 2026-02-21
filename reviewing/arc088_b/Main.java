import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        int result = -1;
        int lower = 1;
        int upper = S.length();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (check(S, middle)) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }

    static boolean check(String S, int K) {
        int leftIndex = S.length() - K;
        int rightIndex = K - 1;

        return leftIndex > rightIndex
                || IntStream.rangeClosed(leftIndex, rightIndex).map(S::charAt).distinct().count() == 1;
    }
}