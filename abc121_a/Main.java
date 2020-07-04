import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();

        System.out.println(solve(H, W, h, w));

        sc.close();
    }

    static int solve(int H, int W, int h, int w) {
        return (H - h) * (W - w);
    }
}