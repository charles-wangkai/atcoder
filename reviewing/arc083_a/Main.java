import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();
        int F = sc.nextInt();

        System.out.println(solve(A, B, C, D, E, F));

        sc.close();
    }

    static String solve(int A, int B, int C, int D, int E, int F) {
        int sugarWater = 100 * A;
        int sugar = 0;
        for (int o1 = 0; 100 * A * o1 <= F; ++o1) {
            for (int o2 = 0; 100 * A * o1 + 100 * B * o2 <= F; ++o2) {
                for (int o3 = 0; 100 * A * o1 + 100 * B * o2 + C * o3 <= F && C * o3 <= (A * o1 + B * o2) * E; ++o3) {
                    for (int o4 = 0; 100 * A * o1 + 100 * B * o2 + C * o3 + D * o4 <= F
                            && C * o3 + D * o4 <= (A * o1 + B * o2) * E; ++o4) {
                        int sw = 100 * A * o1 + 100 * B * o2 + C * o3 + D * o4;
                        int s = C * o3 + D * o4;

                        if (s * sugarWater > sugar * sw) {
                            sugarWater = sw;
                            sugar = s;
                        }
                    }
                }
            }
        }

        return String.format("%d %d", sugarWater, sugar);
    }
}