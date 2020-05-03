import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static long solve(int[] a) {
        return Math.min(computeOperationNum(a, false), computeOperationNum(a, true));
    }

    static long computeOperationNum(int[] a, boolean posOrNeg) {
        long result = 0;
        int sum = 0;
        for (int ai : a) {
            sum += ai;
            if (posOrNeg) {
                if (sum <= 0) {
                    result += 1 - sum;
                    sum = 1;
                }
            } else {
                if (sum >= 0) {
                    result += sum + 1;
                    sum = -1;
                }
            }

            posOrNeg = !posOrNeg;
        }

        return result;
    }
}