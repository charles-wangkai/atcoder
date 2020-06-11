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

    static long solve(int[] A) {
        long result = 0;
        int xor = 0;
        long sum = 0;
        int beginIndex = 0;
        for (int endIndex = 0; endIndex < A.length; ++endIndex) {
            xor ^= A[endIndex];
            sum += A[endIndex];
            while (xor != sum) {
                xor ^= A[beginIndex];
                sum -= A[beginIndex];
                ++beginIndex;
            }

            result += endIndex - beginIndex + 1;
        }

        return result;
    }
}