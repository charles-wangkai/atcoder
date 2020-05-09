import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(a));

        sc.close();
    }

    static int solve(int[] a) {
        boolean[] visited = new boolean[a.length];
        visited[0] = true;
        int index = 0;
        for (int step = 1;; ++step) {
            index = a[index];
            if (index == 1) {
                return step;
            }
            if (visited[index]) {
                return -1;
            }

            visited[index] = true;
        }
    }
}