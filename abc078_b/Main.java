import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();

        System.out.println(solve(X, Y, Z));

        sc.close();
    }

    static int solve(int X, int Y, int Z) {
        int result = 0;
        while ((result + 1) * Y + (result + 2) * Z <= X) {
            ++result;
        }

        return result;
    }
}