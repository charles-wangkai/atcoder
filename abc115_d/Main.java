import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long X = sc.nextLong();

        System.out.println(solve(N, X));

        sc.close();
    }

    static long solve(int N, long X) {
        long[] totalNums = new long[N + 1];
        totalNums[0] = 1;
        for (int i = 1; i < totalNums.length; ++i) {
            totalNums[i] = totalNums[i - 1] * 2 + 3;
        }

        long[] pattyNums = new long[N + 1];
        pattyNums[0] = 1;
        for (int i = 1; i < pattyNums.length; ++i) {
            pattyNums[i] = pattyNums[i - 1] * 2 + 1;
        }

        return search(totalNums, pattyNums, N, X);
    }

    static long search(long[] totalNums, long[] pattyNums, int level, long x) {
        if (level == 0) {
            return 1;
        }

        if (x == 1) {
            return 0;
        } else if (x <= totalNums[level - 1] + 1) {
            return search(totalNums, pattyNums, level - 1, x - 1);
        } else if (x == totalNums[level - 1] + 2) {
            return pattyNums[level - 1] + 1;
        } else if (x <= totalNums[level - 1] * 2 + 2) {
            return pattyNums[level - 1] + 1 + search(totalNums, pattyNums, level - 1, x - (totalNums[level - 1] + 2));
        } else {
            return pattyNums[level];
        }
    }
}