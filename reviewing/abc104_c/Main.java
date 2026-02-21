import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int G = sc.nextInt();
        int[] p = new int[D];
        int[] c = new int[D];
        for (int i = 0; i < D; ++i) {
            p[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        System.out.println(solve(p, c, G));

        sc.close();
    }

    static int solve(int[] p, int[] c, int G) {
        int D = p.length;

        int result = Integer.MAX_VALUE;
        for (int code = 0; code < (1 << D); ++code) {
            int problemNum = 0;
            int rest = G;
            for (int i = 0; i < D; ++i) {
                if ((code & (1 << i)) != 0) {
                    problemNum += p[i];
                    rest -= 100 * (i + 1) * p[i] + c[i];
                }
            }

            for (int i = D - 1; i >= 0; --i) {
                if ((code & (1 << i)) == 0) {
                    int pn = Math.min(p[i] - 1, (Math.max(0, rest) + 100 * (i + 1) - 1) / (100 * (i + 1)));

                    problemNum += pn;
                    rest -= 100 * (i + 1) * pn;
                }
            }

            if (rest <= 0) {
                result = Math.min(result, problemNum);
            }
        }

        return result;
    }
}