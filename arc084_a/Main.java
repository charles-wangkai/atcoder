import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = readArray(sc, N);
        int[] B = readArray(sc, N);
        int[] C = readArray(sc, N);

        System.out.println(solve(A, B, C));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static long solve(int[] A, int[] B, int[] C) {
        A = Arrays.stream(A).boxed().sorted().mapToInt(x -> x).toArray();
        C = Arrays.stream(C).boxed().sorted().mapToInt(x -> x).toArray();

        int[] A_ = A;
        int[] C_ = C;
        return Arrays.stream(B).mapToLong(b -> (long) computeLessNum(A_, b) * computeGreaterNum(C_, b)).sum();
    }

    static int computeLessNum(int[] values, int target) {
        int index = -1;
        int lower = 0;
        int upper = values.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (values[middle] < target) {
                index = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return index + 1;
    }

    static int computeGreaterNum(int[] values, int target) {
        int index = values.length;
        int lower = 0;
        int upper = values.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (values[middle] > target) {
                index = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return values.length - index;
    }
}